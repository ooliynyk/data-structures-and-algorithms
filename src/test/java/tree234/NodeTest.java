package tree234;

import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {

    @Test
    public void nodeShouldBeEmptyAndLeaf() {
        Node<Integer> node = new Node<>();
        assertFalse(node.isFull());
        assertTrue(node.isLeaf());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailWithInvalidValuePosition() {
        Node<Integer> node = new Node<>();
        node.setValueAt(15, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailWithInvalidChildPosition() {
        Node<Integer> node = new Node<>();
        node.setChildAt(new Node<>(), -1);
    }

}