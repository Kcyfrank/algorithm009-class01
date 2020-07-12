import java.util.Map;

import sun.net.www.content.audio.basic;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU缓存机制
 */

// @lc code=start
class LRUCache {
    class DlinkedNode {
        int key;
        int value;
        DlinkedNode prev;
        DlinkedNode next;
        public DlinkedNode() {}
        public DlinkedNode(int _key,int _value){
            key =_key;
            value=_value;
        }
    }

    private Map<Integer, DlinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DlinkedNode head, tail;
    
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity= capacity;
        head = new DlinkedNode();
        tail = new DlinkedNode();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        DlinkedNode node = cache.get(key);
        if(node == null){
            return -1;
       }
       moveToHead(node);
       return node.value;
    }
    
    public void put(int key, int value) {
        DlinkedNode node = cache.get(key);
        if(node == null){
            DlinkedNode newNode = new DlinkedNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            ++size;
            if(size>capacity){
                DlinkedNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }   
        }else{
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DlinkedNode node){
        node.prev=  head;
        node.next = head.next;
        head.next.prev=  node;
        head.next= node;
    }

    private  void removeNode(DlinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DlinkedNode node){
        removeNode(node);
        addToHead(node);
    }

    private DlinkedNode removeTail(){
        DlinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

