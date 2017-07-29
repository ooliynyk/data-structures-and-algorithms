package stacklist;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by oleksandr on 05.07.17.
 */
public class QueueTest {
    @Test
    public void insert() throws Exception {
        Queue queue = new Queue(5);
        assertTrue(queue.isEmpty());
        queue.insert(1);
        queue.insert(2);
        queue.insert(5);
        queue.insert(3);
        assertFalse(queue.isFull());
        assertFalse(queue.isEmpty());
        queue.insert(6);
        assertTrue(queue.isFull());
    }

}