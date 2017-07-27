package stacklist;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by oleksandr on 04.07.17.
 */
public class ReverserTest {
    @Test
    public void reverse() throws Exception {
        Reverser reverser = new Reverser("part");
        assertEquals("trap", reverser.reverse());
    }

}