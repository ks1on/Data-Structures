package Collection.List.MyArrayList;

import Collection.List.MyList;
import Collection.MyCollection;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class MyArrayList<E> implements MyList<E> {
    private static final Integer MIN_SIZE = 10;
    private Object[] data = new Object[MIN_SIZE];
    Integer index = 0;

    @Override
    public boolean add(E e) {
        if (index == data.length) {
            resize();
        }
        data[index] = e;
        index++;
        return true;
    }

    public void addAll(MyCollection<E> collection) {
        Object[] arr = collection.toArray();
        for (int i = 0; i < arr.length; i++) {
            add(collection.get(i));
        }
    }

    private void resize() {
            Object[] temp = new Object[data.length + (data.length >> 1)];
            System.arraycopy(data, 0, temp, 0, data.length);
            data = temp;
    }

    @Override
    public void add(int index, E e) {
        if (index > data.length) {
            resize();
        } else {
            Object o = data[index];
            if (index < this.index) {
                this.index++;
                data[index] = e;
                for (int i = index + 1; i < this.index; i++) {
                        Object v = data[i];
                        data[i] = o;
                        o = v;
                }
            } else {
                this.index++;
                while (data[index - 1] == null) {
                    index--;
                }
                data[index] = e;
            }
        }
    }

    @Override
    public E remove(int index) {
        E e = (E) data[index];
            data[index] = null;
            for (int i = 0; i <= index; i++) {
                if (data[i] == null) {
                    for (int j = i; j < data.length - 1; j++) {
                        Object temp = data[j];
                        data[j] = data[j + 1];
                        data [j + 1] = temp;
                    }
                    this.index--;
                }
            }
            return e;
    }

    public boolean contains(E e) {
        boolean b;
         try {
             b = indexOf(e) >= 0;
         } catch (NoSuchElementException ex) {
             return false;
         }
         return b;
    }

    public Object[] toArray() {
        return Arrays.copyOf(data, index);
    }

    @Override
    public void clear() {
        data = new Object[MIN_SIZE];
        index = 0;
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public E get(int index) {
        return (E) data[index];
    }

    @Override
    public int indexOf(E e) {
        int index = 0;
        for (int i = 0; i < this.index; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return index == 0;
    }

    @Override
    public String toString() {
        StringJoiner s = new StringJoiner(", ");
        for (Object d: data) {
            if (d != null) {
                s.add(d.toString());
            }
        }
        return "[" + s + "]";
    }
}
