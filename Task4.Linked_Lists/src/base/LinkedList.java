package base;

public interface LinkedList<E>  {

    void insertFirst(E value);

    E removeFirst();

    boolean remove(E value);

    boolean contains(E value);

    int size();

    boolean isEmpty();

    void display();

    E getFirst();

    class Node<E> {
        public E item;
        public Node<E> next;
        public Node<E> prev;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
        public Node(E item, Node<E> prev, Node<E> next){
            this.item = item;
            this.next = next;
            this.prev = prev;
        }

        public E getValue() {
            return item;
        }

        public void setValue(E value) {
            this.item = value;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

}
