package tree234;

import java.io.PrintStream;

public class Node {

    private static final int MAX_ITEMS = 4;

    private static final int ITEM_A = 0;
    private static final int ITEM_B = 1;
    private static final int ITEM_C = 2;

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

    public DataItem popItemAt(int position) {
        if (position >= MAX_ITEMS)
            throw new RuntimeException("Position must not be greater than " + (MAX_ITEMS-1));

        DataItem item = items[position];
        items[position] = null;

        return item;
    }

    public boolean isLeaf() {
        return child[0] == null;
    }

    public boolean isFull() {
        return items.length == MAX_ITEMS;
    }

    public void display(PrintStream stream) {
        for (Node children : child) {
            children.display(stream);
        }
    }

    public Node createBrother() {
        Node brother = new Node();
        brother.parent = parent;
        moveDataItem(2, brother);
        moveDataItem(1, parent);

        moveChildren(2, brother);
        moveChildren(3, brother);

        return brother;
    }


    private void addChildrenAfter(Node node, Node newChildren) {
        int position;
        for (position = 0; position < child.length - 1; position++) {
            if (node.equals(child[position])) {
                break;
            }
        }
        child[position + 1] = newChildren;
    }

    private void moveDataItem(int position, Node to) {

    }

    private void moveChildren(int position, Node to) {

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
        }
        return next;
    }

}
