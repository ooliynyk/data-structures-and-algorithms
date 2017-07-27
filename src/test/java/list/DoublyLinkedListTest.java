package list;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by oleksandr on 14.07.17.
 */
public class DoublyLinkedListTest {

    @Test
    public void test() {
        DoublyLinkedList list = new DoublyLinkedList();
        assertTrue(list.isEmpty());

        list.insertFirst(22d);
        list.insertFirst(44d);
        list.insertFirst(66d);

        list.insertLast(11d);
        list.insertLast(33d);
        list.insertLast(55d);

        list.displayForward();
        list.displayBackward();

        assertFalse(list.isEmpty());

        list.removeFirst();
        list.removeLast();
        list.remove(11d);
        list.displayForward();

        list.insertAfter(22d, 77d);
        list.insertAfter(33d, 88d);
        list.displayForward();
    }

}