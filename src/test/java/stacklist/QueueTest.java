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
        queue.insert(1L);
        queue.insert(2L);
        queue.insert(5L);
        queue.insert(3L);
        assertFalse(queue.isFull());
        assertFalse(queue.isEmpty());
        queue.insert(6L);
        assertTrue(queue.isFull());
    }

}