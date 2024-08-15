package Collection.Queue;

import Collection.MyCollection;

public interface MyQueue<E> extends MyCollection<E> {

    boolean offer(E e);

    E remove();

    E poll();

    E element();

    E peek();

}
