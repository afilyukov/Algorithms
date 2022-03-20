package base;

import base.LinkedList;

public interface TwoSideLinkedList<E>  extends LinkedList<E> {

    void insertLast(E value);
    E removeLast();
    E getLast();
    boolean insert(int index, E value);
}
