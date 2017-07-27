package array;

import array.Array;
import array.SelectArray;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by oleksandr on 30.06.17.
 */
public class SelectArrayTest {
    @Test
    public void sort() throws Exception {
        Array array = new SelectArray(3);
        array.insert(2L);
        array.insert(4L);
        array.insert(1L);
        assertEquals(0, array.search(2L));
        array.sort();
        assertEquals(1, array.search(2L));
    }

}