package recursion;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class QuickSortTest {
    @Test
    public void sort() throws Exception {
        int[] array = new int[]{1, 4, 2, 7, 1, 3, 0, 9};
        QuickSort quickSort = new QuickSort(array);
        quickSort.sort();
        System.out.println(Arrays.toString(array));
    }

}