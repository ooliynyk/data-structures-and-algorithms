package tree234;

import java.io.PrintStream;

public class Node {

    private static final int MAX_ITEMS = 3;
    private static final int MAX_CHILDREN = 4;

    private DataItem[] items = new DataItem[MAX_ITEMS];
    private int itemsElements = 0;
    private int childrenElements = 0;

    private Node[] children = new Node[MAX_CHILDREN];
    private Node parent;

    public static Node newChildrenOf(Node parent) {
        Node child = new Node();
        child.parent = parent;
        parent.pushChild(child);

        return child;
    }

    public boolean insertItem(DataItem item) {
        if (isFull())
            return false;

        int position = 0;
        while (position < itemsElements && item.compareTo(items[position]) > 0) {
            position++;
        }

        for (int i = items.length - 1; i > position; i--) {
            items[i] = items[i - 1];
        }
        items[position] = item;

        itemsElements++;

        return true;
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
        validateItemPosition(position);

        DataItem item = items[position];
        items[position] = null;

        itemsElements--;

        return item;
    }

    public Node popChild() {
        return (childrenElements != 0) ? children[--childrenElements] : null;
    }

    public void pushChild(Node child) {
        if (child != null) {
            this.children[childrenElements++] = child;
            child.parent = this;
        }
    }

    private static void validateItemPosition(int position) {
        if (position >= MAX_ITEMS)
            throw new RuntimeException("Position must not be greater than " + (MAX_ITEMS - 1));
    }

    public Node getParent() {
        return parent;
    }

    public boolean isLeaf() {
        return childrenElements == 0;
    }

    public boolean isFull() {
        return itemsElements == MAX_ITEMS;
    }

    public void display(PrintStream stream) {
        for (Node children : children) {
            children.display(stream);
        }
    }

    public Node getNextChildBy(DataItem keyItem) {
        for (int i = 0; i < itemsElements - 1; i++) {
            if (keyItem.compareTo(items[i]) > 0 && keyItem.compareTo(items[i + 1]) < 0) {
                return children[i + 1];
            }
        }

        return keyItem.compareTo(items[itemsElements - 1]) > 0 ?
                children[itemsElements] :
                children[itemsElements - 1];
    }

}
