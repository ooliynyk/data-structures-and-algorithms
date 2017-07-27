package array;

import array.InsertSort;
import org.junit.Test;

/**
 * Created by oleksandr on 04.07.17.
 */
public class InsertSortTest {
    @Test
    public void sort() throws Exception {
        InsertSort array = new InsertSort(10);
        array.insert(1L);
        array.insert(2L);
        array.insert(3L);
        array.insert(3L);
        array.insert(5L);
        array.insert(1L);
        array.insert(6L);
        array.insert(2L);
        System.out.println(array);
        array.sort();
        //array.noDups();
        System.out.println(array);
    }

    @Test
    public void noDubs() throws Exception {
    }

}