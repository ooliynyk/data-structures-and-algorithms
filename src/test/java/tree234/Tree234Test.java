package tree234;

import common.DataItem;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class Tree234Test {

    @Test
    public void insert() throws Exception {
        Tree234 tree = new Tree234();
        tree.insert(new DataItem(70));
        tree.insert(new DataItem(50));
        tree.insert(new DataItem(30));
        tree.insert(new DataItem(40));
        tree.insert(new DataItem(20));
        tree.insert(new DataItem(80));
        tree.insert(new DataItem(25));
        tree.insert(new DataItem(90));
        tree.insert(new DataItem(75));
        tree.insert(new DataItem(10));
    }

}