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

    @Test(expected = IllegalStateException.class)
    public void insertValueIntoFullNodeShouldFail() {
        Node<Integer> node = new Node<>();
        for (int i = 0; i < Node.VALUES+1; i++) {
            node.addValue(i);
        }
    }

 /*   @Test(expected = IllegalArgumentException.class)
    public void shouldFailWithInvalidChildPosition() {
        Node<Integer> node = new Node<>();
        node.addChild(new Node<>(), -1);
    }*/

}