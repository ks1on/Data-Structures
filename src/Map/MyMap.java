package Map;

public interface MyMap<K, V> {

    boolean put(K key, V value);

    V remove(K key);

    V get(K key);

    int size();

    void clear();

    boolean containsKey(K key);

    boolean containsValue(V value);

    boolean isEmpty();
}
