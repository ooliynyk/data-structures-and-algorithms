package array;

import array.Array;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr on 29.06.17.
 */
public class ArrayTest {

    @Test
    public void insert() {
        Array array = new Array(10);
        array.insert(123L);
        assertEquals("should be 1",1, array.size());
        assertEquals("should be 0",0, array.search(123L));
    }

    @Test
    public void deleteAll() {
        Array array = new Array(10);
        array.insert(1L);
        array.insert(2L);
        array.insert(1L);

        array.delete(1L);
        array.delete(2L);
        assertEquals("should be 0",0, array.size());
    }

}
