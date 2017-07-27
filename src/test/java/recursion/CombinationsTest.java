package recursion;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class CombinationsTest {
    @Test
    public void solve() throws Exception {
        Combinations combinations = new Combinations();
        System.out.println(combinations.solve(new char[]{'A', 'B', 'C'}, 2));
    }

}