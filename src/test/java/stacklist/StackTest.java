package stacklist;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by oleksandr on 04.07.17.
 */
public class StackTest {
    @Test
    public void push() throws Exception {
        Stack stack = new Stack(4);
        stack.push('a');
        stack.push('b');
        stack.push('c');
        stack.push('f');
        assertTrue(stack.isFull());
        assertFalse(stack.isEmpty());

        for (int i = 0; i < 4; i++) {
            assertFalse(stack.isEmpty());
            long value = stack.pop();
            System.out.println(value);
        }
        assertTrue(stack.isEmpty());
    }

}