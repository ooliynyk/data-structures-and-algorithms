package tree234;

public class Node <T extends Comparable> {

    public static final int VALUES = 3;
    public static final int CHILDREN = 4;

    private T[] values;
    private Node<T>[] children;

    public Node() {
        values = (T[]) new Comparable[VALUES];
        children = (Node<T>[]) new Node[CHILDREN];
    }

    public boolean isLeaf() {
        return children[0] == null;
    }

    public boolean isFull() {
        return values[VALUES-1] != null;
    }

    public int values() {
        int count;
        for (count = 0; count < VALUES; count++) {
            if (values[count] == null) {
                break;
            }
        }
        return count;
    }

    public void addValue(T value) {
        if (isFull()) {
            throw new IllegalStateException("Node is full");
        }
        int position;
        for (position = 0; position < values(); position++) {
            if (value.compareTo(values[position]) < 0) {
                break;
            }
        }


        for (int i = VALUES-1; i > position; i--) {
            values[i] = values[i-1];
        }
        values[position] = value;
    }

    public T getValueAt(int position) {
        validateValuePosition(position);
        return values[position];
    }

    public T removeValueAt(int position) {
        validateValuePosition(position);

        T removableValue = values[position];
        values[position] = null;
        return removableValue;
    }

    public void addChild(Node<T> newChild) {
        int position;
        for (position = 0; position < CHILDREN; position++) {
            Node<T> current = children[position];
            if (current == null) {
                break;
            }

            T newChildFirstValue = newChild.getValueAt(0);
            T currentChildFirstValue = current.getValueAt(0);
            if (newChildFirstValue.compareTo(currentChildFirstValue) < 0) {
                break;
            }
        }
        for (int i = CHILDREN-1; i > position; i--) {
            children[i] = children[i-1];
        }
        children[position] = newChild;
    }

    public Node<T> getChildAt(int position) {
        validateChildPosition(position);
        return children[position];
    }

    public Node<T> removeChildAt(int position) {
        if (isLeaf()) {
            throw new IllegalStateException("Node is a leaf");
        }
        validateChildPosition(position);
        Node<T> removableChild = children[position];
        children[position] = null;
        return removableChild;
    }

    private static void validateChildPosition(int position) {
        if (position < 0 || position > CHILDREN-1) {
            throw new IllegalArgumentException("Position is out of bounds: " + position);
        }
    }

    private static void validateValuePosition(int position) {
        if (position < 0 || position > VALUES-1) {
            throw new IllegalArgumentException("Position is out of bounds: " + position);
        }
    }

}
