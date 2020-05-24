class Solution {
    public static void main(String[] args) {
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
        // 改写后输出
        // [c, b, a]
        // c
        // [c, b, a]
        // c
        // b
        // a
        // []
    }
    /*public static void main(String[] args) {
        Deque<String> deque = new LinkedList<String>();

        deque.push("a");
        deque.push("b");
        deque.push("c");
        System.out.println(deque);

        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size() > 0) {
            System.out.println(deque.pop());
        }
        System.out.println(deque);
        // 改写前输出
        // [c, b, a]
        // c
        // [c, b, a]
        // c
        // b
        // a
        // []
    }*/
}

