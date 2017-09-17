package heap;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by oleksandr on 17.09.17.
 */
public class HeapTest {
    @Test
    public void insertAndRemove() throws Exception {
        Heap<Integer> heap = new Heap<>(3);
        heap.insert(6);
        heap.insert(1);
        heap.insert(2);
        assertEquals(6, (int)heap.remove());
        assertEquals(2, (int)heap.remove());
        assertEquals(1, (int)heap.remove());
    }

}