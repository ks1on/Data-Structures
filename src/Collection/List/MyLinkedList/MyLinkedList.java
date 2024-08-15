package Collection.List.MyLinkedList;

import Collection.MyCollection;
import Collection.List.MyList;
import Collection.Queue.MyQueue;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class MyLinkedList<E> implements MyQueue<E>, MyList<E> {
    private Node<E> first;
    private Node<E> last;
    private int size = 0;


    public boolean contains(E element) {
        try {
            return indexOf(element) >= 0;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public int indexOf(E element) {
        Node<E> f = first;
        for (int i = 0; i < size; i++) {
            if (f.item.equals(element)) {
              return i;
            } else {
                f = f.next;
            }
        }
        return -1;
    }

    public E get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + "out of bonds for size " + size);
        } else if (index < 0) {
            throw new IllegalArgumentException("Invalid request, index < 0");
        }
        Node<E> f = first;
        for (int i = 0; i < index; i++) {
            f = f.next;
        }
        return f.item;
    }

    public void set(int index, E item) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bonds for size " + size);
        } else if (index < 0) {
            throw new IllegalArgumentException("Invalid request, index < 0");
        } else if (index == 0) {
            first.item = item;
        } else {
            Node<E> f = first;
            for (int i = 0; i < index; i++) {
                f = f.next;
            }
            f.item = item;
        }
    }

    public void unlink(Node<E> node) {
        node.next = null;
        node.prev = null;
    }

    public E removeLast() {
        if (last == null) {
            return null;
        }
        E e = last.item;
        if (last.prev == null) {
            first = null;
            last = null;
            size = 0;
        } else {
            Node<E> l = last.prev;
            unlink(last);
            l.next = null;
            size--;
        }
        return e;
    }

    public E removeFirst() {
        if (first == null) {
            return null;
        }
        E e = first.item;
        if (first.next == null) {
            first = null;
            last = null;
            size = 0;
        } else {
            Node<E> f = first.next;
            f.prev = null;
            unlink(first);
            first = f;
            size--;
        }
        return e;
    }

    public E remove(E item) {
        E e;
        Node<E> f = first;
        int counter = 0;
        boolean isNode = false;
        for (int i = 0; i < size; i++) {
            if (f.item.equals(item)) {
                isNode = true;
                counter = i;
                } else {
                f = f.next;
            }
            if (isNode) {
                if (counter == 0) {
                    return removeFirst();
                } else if (counter == size - 1) {
                    return removeLast();
                } else {
                    e = f.item;
                    Node<E> prev = f.prev;
                    Node<E> next = f.next;
                    prev.next = next;
                    next.prev = prev;
                    unlink(f);
                    size--;
                    return e;
                }
            }
        }
        throw new NoSuchElementException("Element \"" + item + "\" does not found in the list");
    }

    @Override
    public E remove(int index) {
        E e;
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bonds for size " + size);
        }
        if (index == size - 1) {
            return removeLast();
        } else if (index == 0) {
            return removeFirst();
        } else {
            Node<E> f = first;
            for (int i = 0; i < index; i++) {
                f = f.next;
            }
            e = f.item;
            Node<E> prev = f.prev;
            Node<E> next = f.next;
            prev.next = next;
            next.prev = prev;
            unlink(f);
            size--;
        }
        return e;
    }


    public void addLast(E element) {
        Node<E> l = last;
        Node<E> n = new Node<>(l, element, null);
        last = n;
        if (l == null) {
            first = n;
        } else {
            l.next = n;
        }
        size++;

    }

    public void addFirst(E element) {
        Node<E> f = first;
        Node<E> n = new Node<>(null, element, f);
        first = n;
        if (f == null) {
            last = n;
        } else {
            f.prev = n;
        }
        size++;
    }

    public void add(int index, E element) {
        if (index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bonds for size " + size);
        }

        if (index == 0) {
            addFirst(element);
        } else if (index == size) {
            addLast(element);
        } else {
            Node<E> f = first;
            for (int i = 0; i < index; i++) {
                f = f.next;
            }
            Node<E> nn = f.prev;
            Node<E> node = new Node<>(f.prev, element, f);
            nn.next = node;
            f.prev = node;
            size++;
        }
    }

    public void addAll(MyCollection<E> list) {
        Object[] l = list.toArray();
        for (int i = 0; i < l.length; i++) {
            addLast((E) l[i]);
        }
    }

    public Object[] toArray() {
        Object[] arr = new Object[size];
        Node<E> node = first;
        int i = 0;
        while (node != null) {
            arr[i] = node.item;
            node = node.next;
            i++;
        }
        return arr;
    }

    public void clear() {
        Node<E> f = first;
        for (int i = 0; i < size; i++) {
            Node<E> next = f.next;
            f.item = null;
            unlink(f);
            f = next;
        }
        first = last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
            StringJoiner nods = new StringJoiner(", ");
            Node<E> f = first;
            for (int i = 0; i < size; i++) {
                if (f.item == null) {
                    nods.add(null);
                } else {
                    nods.add(f.item.toString());
                }
                f = f.next;
            }
            return "[" + nods + "]";
    }

    /**
     * Queue implementation
     */

    @Override
    public boolean add(E e) {
        if (first == null) {
            addFirst(e);
        } else {
            addLast(e);
        }
        return true;
    }

    @Override
    public boolean offer(E e) {
        return add(e);
    }

    @Override
    public E remove() {
        E item = first.item;
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        } else {
            removeFirst();
        }
        return item;
    }

    @Override
    public E poll() {
        return first == null ? null : removeFirst();
    }

    @Override
    public E element() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        } else {
            return first.item;
        }
    }

    @Override
    public E peek() {
        return first == null ? null : first.item;
    }

    public static class Node<E> {
        private Node<E> prev;
        private E item;
        private Node<E> next;

        public Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }

        public boolean hasNext() {
            return next != null;
        }
    }
}
