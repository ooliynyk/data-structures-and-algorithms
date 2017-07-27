package array;

import array.SortedArray;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by oleksandr on 29.06.17.
 */
public class SortedArrayTest {

    @Test
    public void shouldFindNothing() {
        SortedArray sortedArray = new SortedArray(10);
        assertEquals(0, sortedArray.search(1L));
    }

    @Test
    public void shouldFindElement() {
        SortedArray array = new SortedArray(10);
        array.insert(343L);
        array.insert(123L);
        assertEquals(0, array.search(123L));
        assertEquals(1, array.search(343L));
    }

    @Test
    public void shouldDelete() {
        SortedArray array = new SortedArray(10);
        assertFalse("array should be empty" , array.delete(123L));
        array.insert(123L);
        assertTrue("array should contains 123", array.delete(123L));
        assertFalse(array.delete(123L));
    }

}