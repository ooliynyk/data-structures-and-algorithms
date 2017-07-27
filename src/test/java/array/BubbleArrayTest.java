package array;

import array.BubbleArray;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by oleksandr on 30.06.17.
 */
public class BubbleArrayTest {

    @Test
    public void sort() throws Exception {
        BubbleArray array = new BubbleArray(3);
        array.insert(3L);
        array.insert(6L);
        array.insert(1L);
        assertEquals(0, array.search(3L));
        assertEquals(2, array.search(1L));
        array.sort();
        assertEquals(1, array.search(3L));
        assertEquals(0, array.search(1L));
    }

}