package Map;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

public class MyHashMap<K, V> implements MyMap<K, V> {

    private static final int MIN_CAPACITY = 16;
    private Node[] buckets = new Node[MIN_CAPACITY];
    private int size = 0;
    private int MAX_SIZE = 160;

    @Override
    public boolean put(K key, V value) {
        if (size > MAX_SIZE) {
            resize();
            MAX_SIZE *= 2;
        }
        Node<K, V> node = new Node<>(key, value);
        int index = node.hashCode() & (buckets.length - 1);
        Node<K, V> head = buckets[index];
        if (head == null) {
            head = node;
            buckets[index] = head;
            size++;
        } else {
            Node<K, V> h = head;
            while (h != null) {
                if (checkNodes(node, h)) {
                    h.value = node.value;
                    return true;
                } else if (!h.hasNext()){
                    h.next = node;
                    size++;
                }
                h = h.next;
            }
        }
        return true;
    }

    public boolean checkNodes(Node<K, V> node, Node<K, V> anotherNode) {
        if (node.key.hashCode() == anotherNode.key.hashCode()) {
            return node.key.equals(anotherNode.key);
        }
        return false;
    }

    @Override
    public V remove(K key) {
        int index = Objects.hash(key) & buckets.length - 1;
            Node<K, V> head = buckets[index];
            V value = null;
            if (head == null) {
                throw new NoSuchElementException("Element \"" + key + "\" not found");
            }
                if (key.equals(head.key)) {
                    value = head.value;
                    buckets[index] = head.next;
                    size--;
                } else {
                    while (head.hasNext()) {
                        if (head.next.key.equals(key)) {
                            value = head.next.value;
                            head.next = head.next.next;
                            size--;
                        } else {
                            head = head.next;
                        }
                    }
                }
        return value;
    }

    @Override
    public V get(K key) {
        Node<K, V> head = buckets[Objects.hash(key) & buckets.length - 1];
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        throw new NoSuchElementException("Element \"" + key + "\" not found");
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        Arrays.fill(buckets, null);
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean containsKey(K key) {
        Node<K, V> head = buckets[Objects.hash(key) & buckets.length - 1];
        while(head != null) {
            if (head.key.equals(key)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public boolean containsValue(V value) {
        for (Node<K, V> bucket : buckets) {
            Node<K, V> head = bucket;
            while (head != null) {
                if (head.value.equals(value)) {
                    return true;
                }
                head = head.next;
            }
        }
        return false;
    }

    private void resize() {
        Node<K, V>[] old = buckets;
        buckets = new Node[buckets.length + (buckets.length << 1)];
        size = 0;
        for (Node<K, V> head: old) {
            while (head != null) {
                put(head.key, head.value);
                head = head.next;
            }
        }
    }

    public static class Node<K, V> {
        private final K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public boolean hasNext() {
            return next != null;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (getClass() != obj.getClass()) return false;
            return key == ((Node<K, V>) obj).key;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }

        @Override
        public String toString() {
            return key + "=" + value.toString();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (Node<K, V> head: buckets) {
            while (head != null) {
                sb.append(head);
                counter++;
                if (counter != size) {
                    sb.append(", ");
                }
                head = head.next;
            }
        }
        return "{" + sb + "}";
    }

}
