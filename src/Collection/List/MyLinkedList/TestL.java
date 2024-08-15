package Collection.List.MyLinkedList;

import Collection.Queue.MyQueue;


public class TestL {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        MyQueue<String> queue = new MyLinkedList<>();


        queue.add("aa");
        queue.add("bb");
        queue.add("cc");
        queue.add("dd");

//        queue.offer("ee");
//        queue.offer("ff");

//        System.out.println(queue.remove());
//        System.out.println(queue.poll());
//        System.out.println(queue.element());
//        System.out.println(queue.peek());

//        System.out.println(queue);



        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        list.addLast("D");
        list.addLast("A");
        list.addLast("D");
        list.add(null);

        list.remove("D");

//        list.addFirst("a");
//        list.addLast("c");
//        System.out.println(list.indexOf("f"));
//        System.out.println(list.indexOf("D"));
//        list.clear();
//        list.add(1,"E");
//        System.out.println(list.contains("F"));
//        System.out.println(list.contains("D"));
//        System.out.println(list.removeFirst());
//        System.out.println(list.removeLast());
//        System.out.println(list.remove(2));
//        list.remove("D");
//        list.set(0, "F");
//        System.out.println(list.get(3));
//        System.out.println(Arrays.toString(list.toArray()));

//        list.addAll(queue);
//        queue.addAll(list);
        System.out.println(queue);
        System.out.println(list);
    }
}
