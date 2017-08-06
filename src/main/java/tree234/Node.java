package tree234;

import java.io.PrintStream;

public class Node {
    private DataItem[] items;
    private Node[] child;
    private Node parent;

    public int findItem(long key) {

        return -1;
    }

    public void insertItem(DataItem item) {

    }

    public boolean removeItem(DataItem item) {
        return false;
    }

    public boolean isLeaf() {
        return child[0] == null;
    }

    public void display(PrintStream stream) {
        for (Node children : child) {
            children.display(stream);
        }
    }

    public Node getNextChild(long key) {
        Node next = null;
        if (key < items[0].value)
            next = child[0];
        else if (items.length > 1 && key > items[0].value && key < items[1].value)
            next = child[1];
        else if (items.length > 2 && key < items[2].value)
            next = child[2];
        else if (items.length == 4 && key > items[3].value) {
            next = child[3];
            rearrange();
        }
        return next;
    }

    private void rearrange() {

    }

}
