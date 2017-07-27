package complexSort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PartitionerTest {
    @Test
    public void partition() throws Exception {
        int[] array = {1, 6, 3, 9, 2, 5};
        Partitioner partitioner = new Partitioner(array);
        System.out.println(Arrays.toString(array));
    }

}