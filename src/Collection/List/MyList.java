package Collection.List;

import Collection.MyCollection;

public interface MyList<E> extends MyCollection<E> {

    void add(int index, E e);

    int indexOf(E item);

}
