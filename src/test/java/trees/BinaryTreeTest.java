package trees;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeTest {
    @Test
    public void remove() throws Exception {
        BinaryTree tree = new BinaryTree();
        tree.insert('a', 11);
        tree.insert('a', 12);
        assertNotNull(tree.find(11));
        assertNotNull(tree.find(12));
        assertTrue(tree.remove(11));
        assertTrue(tree.remove(12));
        assertFalse(tree.remove(11));
        assertNull(tree.find((11)));
        assertNull(tree.find(12));
    }

    @Test
    public void iterate() throws Exception {
        BinaryTree tree = new BinaryTree();
        tree.insert('a', 11);
        tree.insert('a', 45);
        tree.insert('a', 858);
        tree.iterate();
    }

    @Test
    public void find() throws Exception {
        BinaryTree tree = new BinaryTree();
        tree.insert('a', 11);
        tree.insert('a', 45);
        tree.insert('a', 88);
        assertNotNull(tree.find(88));
        System.out.println(tree.find(45));
        assertNull(tree.find(435435));
    }

}