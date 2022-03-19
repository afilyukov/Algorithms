public class CiclicQueue <E> implements Queue<E>{

    protected final int DEFAULT_TAIL = -1;
    protected final int DEFAULT_HEAD = -1;

    protected final E[] data;
    protected int size;
    protected int tail;
    protected int head;

    public CiclicQueue(int maxSize) {
        this.data = (E[]) new Object[maxSize];
        tail = DEFAULT_TAIL;
        head = DEFAULT_HEAD;
    }

    @Override
    public boolean insert(E value) {
        if (isFull()) {
            return false;
        }

        if (head == -1) { head = 0;}

        tail = (++tail) % data.length;

        data[tail] = value;
        size++;
        return true;
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            return null;
        }
        E value = data[head];
        data[head] = null;
        if (head == tail) {
            head = -1;
            tail = -1;
        } else {
            head = (++head) % data.length;
        }
            size--;
        return value;
    }

    @Override
    public E peekFront() {
        return data[head];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i <= data.length-1; i++) {
            sb.append(data[i]);
            if (i != data.length-1) {
                sb.append(", ");
            }
        }
        return sb.append("]").toString();
    }
}
