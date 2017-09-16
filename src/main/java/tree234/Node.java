package tree234;

public class Node <T> {

    public static final int VALUES = 3;
    public static final int CHILDREN = 4;

    private T[] values;
    private Node<T>[] children;

    public Node() {
        values = (T[]) new Object[VALUES];
        children = (Node<T>[]) new Node[CHILDREN];
    }

    public boolean isLeaf() {
        return children[0] == null;
    }

    public boolean isFull() {
        return values[VALUES-1] != null;
    }

    public void setValueAt(T value, int position) {
        if (isFull()) {
            throw new IllegalStateException("Node is full");
        }
        validateValuePosition(position);
        values[position] = value;
    }

    private static void validateValuePosition(int position) {
        if (position < 0 || position > VALUES-1) {
            throw new IllegalArgumentException("Position is out of bounds: " + position);
        }
    }

    public T removeValueAt(int position) {
        validateValuePosition(position);

        T removableValue = values[position];
        values[position] = null;
        return removableValue;
    }

    public void setChildAt(Node<T> newChild, int position) {
        validateChildPosition(position);
        children[position] = newChild;
    }

    public Node<T> getChildAt(int position) {
        validateChildPosition(position);
        return children[position];
    }

    private static void validateChildPosition(int position) {
        if (position < 0 || position > CHILDREN-1) {
            throw new IllegalArgumentException("Position is out of bounds: " + position);
        }
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

}
