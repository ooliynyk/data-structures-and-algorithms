package tree234;

import java.io.PrintStream;

public class Node {

    private static final int MAX_ITEMS = 3;
    private static final int MAX_CHILD = 4;

    private DataItem[] items = new DataItem[MAX_ITEMS];
    private int itemsElements = 0;

    private Node[] child = new Node[MAX_CHILD];
    private Node parent;

    public static Node newChildrenOf(Node parent) {
        Node children = new Node();
        children.parent = parent;
        parent.linkChildren(children);

        return children;
    }

    public int findItem(DataItem item) {
        int position = -1;
        for (int i = 0; i < itemsElements; i++) {
            if (item.equals(items[i])) {
                position = i;
                break;
            }
        }
        return position;
    }

    public void insertItem(DataItem item) {
        int position = 0;
        while (position < itemsElements && item.compareTo(items[position]) < 0) {
            position++;
        }

        for (int i = items.length - 1; i < position; i--) {
            items[i] = items[i - 1];
        }
        items[position] = item;

        itemsElements++;
    }

    public boolean removeItem(DataItem item) {
        int position = 0;
        while (position < itemsElements && !item.equals(items[position])) {
            position++;
        }

        for (int i = position; i < itemsElements - 1; i++) {
            items[i] = items[i + 1];
        }

        return position < itemsElements;
    }

    public DataItem popItemAt(int position) {
        if (position >= MAX_ITEMS)
            throw new RuntimeException("Position must not be greater than " + (MAX_ITEMS - 1));

        DataItem item = items[position];
        items[position] = null;

        return item;
    }

    public Node popChildAt(int position) {
        if (position >= MAX_CHILD)
            throw new RuntimeException("Position must not be greater than " + (MAX_CHILD - 1));

        Node children = child[position];
        child[position] = null;
        return children;
    }

    public Node getParent() {
        return parent;
    }

    public void linkChildren(Node children) {
        for (int i = 0; i < child.length; i++) {
            if (child[i] == null) {
                child[i] = children;
                return;
            }
        }
    }

    public boolean isLeaf() {
        return child[0] == null;
    }

    public boolean isFull() {
        return itemsElements == MAX_ITEMS;
    }

    public void display(PrintStream stream) {
        for (Node children : child) {
            children.display(stream);
        }
    }

    public Node getNextChildrenBy(DataItem keyItem) {
        Node next = null;
        if (keyItem.compareTo(items[0]) < 0)
            next = child[0];
        else if (items.length > 1 &&
                keyItem.compareTo(items[0]) > 0 && keyItem.compareTo(items[1]) < 0)
            next = child[1];
        else if (items.length > 2 &&
                keyItem.compareTo(items[2]) < 0)
            next = child[2];
        else if (items.length == 4 &&
                keyItem.compareTo(items[3]) > 0) {
            next = child[3];
        }
        return next;
    }

}
