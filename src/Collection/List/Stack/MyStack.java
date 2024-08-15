package Collection.List.Stack;

import Collection.List.MyLinkedList.MyLinkedList;

import java.util.EmptyStackException;

public class MyStack<E> extends MyLinkedList<E> {
    private Node<E> first;
    private Node<E> last;


    public E push(E item) {
        addLast(item);
        return item;
    }

    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return removeLast();
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return super.peek();
    }

}
