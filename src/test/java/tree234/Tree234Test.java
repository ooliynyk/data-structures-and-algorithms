package tree234;

import org.junit.Test;

public class Tree234Test {
    @Test
    public void insert() throws Exception {
        Tree234 tree = new Tree234();
        tree.insert(new DataItem(3));
        tree.insert(new DataItem(4));
        tree.insert(new DataItem(5));
        tree.insert(new DataItem(6));
    }

}