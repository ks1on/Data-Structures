package Map;


public class TestMap {
    public static void main(String[] args) {
        MyHashMap<String, Integer> hp = new MyHashMap<>();

        hp.put("A", 1);
        hp.put("AAA", 2);
        hp.put("AAAAA", 3);
        hp.put("A", 4);
        hp.put("ksj", 7);


//        System.out.println(hp.remove("AAAAA"));
//        System.out.println(hp.get("ksj"));
//
//        System.out.println(hp.size());
//
//        System.out.println(hp.containsKey("F"));
//
//        System.out.println(hp.containsValue(4));

//        hp.clear();

//        for (int i = 0; i < 165; i++) {
//            hp.put(String.valueOf(i), i);
//        }
//        System.out.println(hp.isEmpty());

        System.out.println(hp.size());
        System.out.println(hp);
    }
}
