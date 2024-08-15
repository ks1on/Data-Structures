package Collection.List.MyArrayList;

import Collection.List.MyLinkedList.MyLinkedList;

public class MyArrayListTests {
    public static void main(String[] args) {
        MyArrayList<String> test = new MyArrayList<>();
        MyLinkedList<String> t = new MyLinkedList<>();

        t.add("a");
        t.add("b");
        t.add("c");
        t.add("d");

        test.add("A");
        test.add("B");
        test.add("C");
        test.add("D");

        test.add(9, "F");
//        test.remove(4);
//        System.out.println(test.indexOf("C"));
//        test.remove(3);
//        System.out.println(test.isEmpty());
//        System.out.println(test.size());
//        System.out.println(test.contains("F"));
//        System.out.println(test.contains("V"));
//        System.out.println(test.get(3));
//        test.clear();
//        test.addAll(t);

//        test.addAll(t);
        System.out.println(test);
    }
}
