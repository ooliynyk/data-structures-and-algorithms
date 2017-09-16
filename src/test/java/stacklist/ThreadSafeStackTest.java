package stacklist;

import org.junit.Test;

import static org.junit.Assert.*;

public class ThreadSafeStackTest {

    @Test
    public void testPushAndPop() {
        ThreadSafeStack<Integer> stack = new ThreadSafeStack<>();
        stack.push(8);
        stack.push(16);
        stack.push(32);
        assertEquals(32, stack.pop().intValue());
        assertEquals(16, stack.pop().intValue());
        assertEquals(8, stack.pop().intValue());
    }

    @Test(expected = RuntimeException.class)
    public void testPopWhenStackIsEmpty() {
        ThreadSafeStack<Integer> stack = new ThreadSafeStack<>();
        stack.pop();
    }

    @Test
    public void testIsEmpty() {
        ThreadSafeStack<Integer> stack = new ThreadSafeStack<>();
        assertTrue(stack.isEmpty());
        stack.push(42);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }

}