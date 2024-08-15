package Collection;

public interface MyCollection<E> {

    boolean add(E e);

    void addAll(MyCollection<E> collection);

    E remove(int index);

    E get(int index);

    Object[] toArray();

    void clear();

    int size();

    boolean isEmpty();

}
