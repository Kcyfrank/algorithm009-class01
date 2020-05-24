### 学习笔记

刻意练习  五毒神掌（五遍刷题法）
* 第一遍    
5分钟 （读题+思考）  
时间内没有思路 直接看多种解法 并且比较优劣
背诵默写好对应的写法
            
*    第二遍   
马上自己写并且提交leetcode  
多解法比较、体会-》优化 时空复杂度

*    第三遍    
一天后重新做题  
不同解法的数量程度-》专项练习

*    第四遍    
过了一周：反复回来练习相同的题目
             
*    第五遍    
面试前一周恢复性训练

熟悉刷题法的使用。明确第一遍和第二遍的具体使用。


#### 使用新接口改写Deque
        
        Deque<String> deque = new LinkedList<>();

        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);

        String str = deque.getFirst();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size() > 0) {
            System.out.println(deque.removeFirst());
        }
        System.out.println(deque);

#### 源码分析 Queue

     /**
      * 在Collection的基础上追加元素的插入 删除 和提取操作
      * 同时以上操作均存在两套，一套失败报错 一套失败返回null或false
      * 通常为FIFO(先进先出) 排序
      **/
     public interface Queue<E> extends Collection<E> {
         /**
          * 向队列中插入新的元素
          * 若队列已满 返回异常
          */
         boolean add(E e);
 
         /**
          * 向队列中插入新的元素
          * 若队列已满 返回false
          */
         boolean offer(E e);
     
         /**
          * 删除队列的第一个元素
          * 当队列为空时 返回异常
          */
         E remove();
     
         /**
          * 删除队列的第一个元素
          * 当队列为空时 返回null
          */
         E poll();
     
         /**
          * 获取队列的第一个元素 不删除
          * 当队列为空时 返回异常
          */
         E element();
     
         /**
          * 获取队列的第一个元素 不删除
          * 当队列为空时 返回null
          */
         E peek();
     }

#### 源码分析 PriorityQueue
    /**
     * PriorityQueue 继承自 AbstractQueue ，
     * AbstractQueue 继承了 AbstractCollection 并 实现了 Queue
     **/
    public class PriorityQueue<E> extends AbstractQueue<E> implements Serializable{
      private static final int DEFAULT_CAPACITY = 11;
    
      private static final long serialVersionUID = -7720805057305804111L;
    
      /** storage中实际使用的元素数.  */
      int used;
    
      /**
       * 这是基础二项式堆的存储。
       * 这个想法是，每个节点都小于或等于其子节点。
       * 索引为N（从0开始）的节点有两个直接子节点，位于
       * 节点2N + 1和2N + 2。
       */
      E[] storage;
    
      /**
       * 比较器实现，为空时默认自然排序.
       */
      Comparator<? super E> comparator;
    
      public PriorityQueue()
      {
        this(DEFAULT_CAPACITY, null);
      }
    
      public PriorityQueue(Collection<? extends E> c){
        this(Math.max(1, (int) (1.1 * c.size())), null);
    
        // 特殊情况，如果初始化集合是已排序集合.
        if (c instanceof SortedSet){
            SortedSet<? extends E> ss = (SortedSet<? extends E>) c;
            this.comparator = (Comparator<? super E>) ss.comparator();
            // 如果元素已被排序，直接插入该元素 .
            int i = 0;
            for (E val : ss)
              {
                if (val == null)
                  throw new NullPointerException();
                storage[i++] = val;
              }
          }
        else if (c instanceof PriorityQueue){
            PriorityQueue<? extends E> pq = (PriorityQueue<? extends E>) c;
            this.comparator = (Comparator<? super E>)pq.comparator();
            // 对元素进行排序再复制排序后的结果作为新的 优先队列的结果.
            System.arraycopy(pq.storage, 0, storage, 0, pq.storage.length);
          }
    
        addAll(c);
      }
    
      public PriorityQueue(int cap){
        this(cap, null);
      }
    
      public PriorityQueue(int cap, Comparator<? super E> comp){
        if (cap < 1)
          throw new IllegalArgumentException();      
        this.used = 0;
        this.storage = (E[]) new Object[cap];
        this.comparator = comp;
      }
    
      public PriorityQueue(PriorityQueue<? extends E> c){
        this(Math.max(1, (int) (1.1 * c.size())),
             (Comparator<? super E>)c.comparator());
        // We can just copy the contents.
        System.arraycopy(c.storage, 0, storage, 0, c.storage.length);
      }
    
      public PriorityQueue(SortedSet<? extends E> c){
        this(Math.max(1, (int) (1.1 * c.size())),
             (Comparator<? super E>)c.comparator());
        //如果需要新增的元素是有序的 直接插入。
        int i = 0;
        for (E val : c)
          {
            if (val == null)
              throw new NullPointerException();
            storage[i++] = val;
          }
      }
    
      public void clear(){
        Arrays.fill(storage, null);
        used = 0;
      }
    
      public Comparator<? super E> comparator(){
        return comparator;
      }
    
      public Iterator<E> iterator(){
        return new Iterator<E>(){
          int index = -1;
          int count = 0;
    
          public boolean hasNext(){
            return count < used;
          }
    
          public E next(){
            while (storage[++index] == null)
              ;
    
            ++count;
            return storage[index];
          }
    
          public void remove() {
            PriorityQueue.this.remove(index);
        index--;
          }
        };
      }
    
      public boolean offer(E o) {
        if (o == null)
          throw new NullPointerException();
    
        int slot = findSlot(-1);
    
        storage[slot] = o;
        ++used;
        bubbleUp(slot);
    
        return true;
      }
    
      public E peek() {
        return used == 0 ? null : storage[0];
      }
    
      public E poll(){
        if (used == 0)
          return null;
        E result = storage[0];
        remove(0);
        return result;
      }
    
      public boolean remove(Object o){
        if (o != null){
            for (int i = 0; i < storage.length; ++i){
                if (o.equals(storage[i])){
                    remove(i);
                    return true;
                  }
              }
          }
        return false;
      }
    
      public int size(){
        return used;
      }
    
      // It is more efficient to implement this locally -- less searching
      // for free slots.
      public boolean addAll(Collection<? extends E> c){
        if (c == this)
          throw new IllegalArgumentException();
    
        int newSlot = -1;
        int save = used;
        for (E val : c){
            if (val == null)
              throw new NullPointerException();
            newSlot = findSlot(newSlot);
            storage[newSlot] = val;
            ++used;
            bubbleUp(newSlot);
          }
    
        return save != used;
      }
    
      int findSlot(int start){
        int slot;
        if (used == storage.length){
            resize();
            slot = used;
          }
        else{
            for (slot = start + 1; slot < storage.length; ++slot){
                if (storage[slot] == null)
                  break;
              }
            // We'll always find a slot.
          }
        return slot;
      }
    
      void remove(int index)
      {
        // Remove the element at INDEX.  We do this by finding the least
        // child and moving it into place, then iterating until we reach
        // the bottom of the tree.
        while (storage[index] != null){
            int child = 2 * index + 1;
    
            // See if we went off the end.
            if (child >= storage.length){
                storage[index] = null;
                break;
              }
    
            // Find which child we want to promote.  If one is not null,
            // we pick it.  If both are null, it doesn't matter, we're
            // about to leave.  If neither is null, pick the lesser.
            if (child + 1 >= storage.length || storage[child + 1] == null){
                // Nothing.
              }
            else if (storage[child] == null
                     || (Collections.compare(storage[child], storage[child + 1],
                                             comparator) > 0))
              ++child;
            storage[index] = storage[child];
            index = child;
          }
        --used;
      }
    
      void bubbleUp(int index){
        // The element at INDEX was inserted into a blank spot.  Now move
        // it up the tree to its natural resting place.
        while (index > 0) {
            // This works regardless of whether we're at 2N+1 or 2N+2.
            int parent = (index - 1) / 2;
            if (Collections.compare(storage[parent], storage[index], comparator)
                <= 0) {
                // Parent is the same or smaller than this element, so the
                // invariant is preserved.  Note that if the new element
                // is smaller than the parent, then it is necessarily
                // smaller than the parent's other child.
                break;
              }
    
            E temp = storage[index];
            storage[index] = storage[parent];
            storage[parent] = temp;
    
            index = parent;
          }
      }
    
      void resize(){
        E[] new_data = (E[]) new Object[2 * storage.length];
        System.arraycopy(storage, 0, new_data, 0, storage.length);
        storage = new_data;
      }
    }
