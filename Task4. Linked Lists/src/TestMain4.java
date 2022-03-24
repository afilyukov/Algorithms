import base.TwoSideLinkedList;

import java.util.LinkedList;

public class TestMain4 {

    public static void main(String[] args) {
        testLinkedList();
        testHomeWork();
    }

    private static void testLinkedList() {

        TwoSideLinkedList<Integer> tsll = new TwoSideLinkedListImpl<>();

        tsll.insertFirst(1);
        tsll.insertFirst(2);
        tsll.insertFirst(3);
        tsll.insertFirst(4);
        tsll.insertFirst(5);
        tsll.insertFirst(6);
        tsll.insertFirst(7);
        tsll.insertFirst(8);
        tsll.insertLast(9);
        tsll.insertLast(10);
        tsll.insertLast(11);
        tsll.display();
        tsll.insert(5, 14);
        tsll.display();

        System.out.println("Find 2: " + tsll.contains(2));

        System.out.println("remove first: " + tsll.removeFirst());
        tsll.display();
        System.out.println("remove first again: " + tsll.removeFirst());
        tsll.display();

        System.out.println("Removed last 3 times");
        tsll.removeLast();
        tsll.removeLast();
        tsll.removeLast();
        tsll.display();
        System.out.println(tsll.size());
        System.out.println(tsll.getLast());
        tsll.removeLast();

        tsll.display();

        testHomeWork();
    }

    private static void testHomeWork() {
        TwoSideLinkedListImpl<Integer> tsll = new TwoSideLinkedListImpl<>();
        tsll.insertFirst(1);
        tsll.insertFirst(2);
        tsll.insertFirst(3);
        tsll.insertFirst(4);
        tsll.insertFirst(5);
        tsll.insertFirst(6);
        tsll.insertFirst(7);
        tsll.insertFirst(8);
        tsll.insertLast(9);
        tsll.insertLast(10);
        tsll.insertLast(11);

        for (Integer value : tsll) {
            System.out.println("value: " + value);
        }

        LinkedList<Integer> ll = new LinkedList<>();
    }
}
