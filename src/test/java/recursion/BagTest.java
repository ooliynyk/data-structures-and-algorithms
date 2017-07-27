package recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class BagTest {
    @Test
    public void solve() throws Exception {
        Bag bag = new Bag();
        System.out.println(bag.solve(new ArrayList<Integer>(Arrays.asList(11, 8, 7, 6, 5)), 20));
    }

}