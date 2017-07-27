package recursion;

import org.junit.Test;

import static org.junit.Assert.*;

public class PowerTest {
    @Test
    public void power() throws Exception {
        Power power = new Power();
        assertEquals(4, power.power(2, 2));
        assertEquals(8, power.power(2, 3));
        assertEquals(387420489, power.power(3, 18));
    }

}