import base.Deque;
import base.LinkedList;
import base.TwoSideLinkedList;

import java.util.Iterator;

public class TwoSideLinkedListImpl<E> extends SimpleLinkedListImpl<E> implements TwoSideLinkedList<E>, Deque<E>, Iterable<E> {

    private Node<E> last;
    private Iterator<E> iterator;

    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public void insertFirst(E value) {
        first = new Node<>(value, null, first);
        size++;
        if (size == 1) {
            last = first;
            return;
        }
        first.getNext().prev = first;
    }

    @Override
    public void insertLast(E value) {
        if (isEmpty()) {
            insertFirst(value);
            return;
        }
        last.next = last = new Node<>(value, last, null);
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node<E> removedNode = first;
        first = removedNode.next;
        first.setPrev(null);
        removedNode.next = null;
        size--;


        if (isEmpty()) {
            first = last = null;
        }

        return removedNode.item;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node<E> removedNode = last;
        if (first==last) {
            size = 0;
            first = last = null;
            return removedNode.item;
        }

       last = removedNode.prev;
       last.next = null;
       size--;

       return removedNode.item;
    }

    @Override
    public boolean remove(E value) {
        Node<E> prev = null;
        Node<E> current = first;

        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            prev = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        if (current == first) {
            removeFirst();
            return true;
        }
        if (current == last) {
            last = prev;
            last.next = null;
        }

        prev.next = current.next;
        current.next = null;
        size--;

        return true;
    }

    @Override
    public boolean insert(int index, E value) {
        if (index > size - 1 || index < 0) {
            return false;
        }
        Node<E> currentNode = null;
        if (index == 0) {
            insertFirst(value);
        } else if (index == size) {
            insertLast(value);
        } else {
            currentNode = first;
            int count = 0;
            while (count != index) {
                currentNode = currentNode.getNext();
                count++;
            }
            Node<E> newNode = new Node<E>(value, currentNode.getPrev(), currentNode);
            currentNode.getPrev().setNext(newNode);
            currentNode.setPrev(newNode);
        }
        size++;
        return true;
    }

    @Override
    public E getLast() {
        return last.item;
    }

    @Override
    public boolean insertLeft(E value) {
        insertFirst(value);
        return true;
    }

    @Override
    public boolean insertRight(E value) {
        insertLast(value);
        return true;
    }

    @Override
    public E removeLeft() {
        return removeFirst();
    }

    @Override
    public E removeRight() {
        return removeLast();
    }

    @Override
    public boolean insert(E value) {
        return false;
    }

    //не реализовывал
    @Override
    public E remove() {
        return null;
    }

    //не реализовывал
    @Override
    public E peekFront() {
        return null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public java.util.Iterator<E> iterator() {
        if (first!=null){
            return new ListIterator<>(first);
        }
        return new ListIterator<>();
    }

    private static class ListIterator<E> implements Iterator<E>{
        private LinkedList.Node<E> current;

        public ListIterator() {
        }

        public ListIterator(LinkedList.Node<E> current) {
            this.current = current;
        }

        public boolean hasNext() {
            return current.getNext() != null;
        }

         @Override
         public E next() {
            current = current.next;
             return current.item;
         }

         public boolean hasPrev() {
            return current.getPrev() != null;
        }

        public E currentValue() {
            return current.getValue();
        }

        public void moveToNext() {
            if (current.getNext() != null) {
                current = current.getNext();
            }
        }

        public void moveToPrev() {
            if (current.getPrev() != null) {
                current = current.getPrev();
            }
        }
     }
}
