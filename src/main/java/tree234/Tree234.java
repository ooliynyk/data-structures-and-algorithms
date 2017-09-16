package tree234;

public class Tree234<T extends Comparable> {

    private Node<T> root;

    public Tree234() {
        root = new Node<>();
    }

    public void insert(T value) {
        Node<T> current = root;
        Node<T> parent = root;
        while (current != null) {
            if (current.isFull()) {
                split(current, parent);
            }

            if (current.isLeaf()) {
                break;
            }

            parent = current;
            current = nextChildForValue(current, value);
            if (current == null) {
                current = parent;
                break;
            }
        }
        current.addValue(value);
    }

    private Node<T> nextChildForValue(Node<T> node, T value) {
        Node<T> nextChild = null;
        for (int i = 0; i < node.values(); i++) {
            if (value.compareTo(node.getValueAt(i)) < 0) {
               nextChild = node.getChildAt(i);
               break;
            }
        }
        if (nextChild == null && value.compareTo(node.getValueAt(node.values()-1)) >= 0) {
            nextChild = node.getChildAt(node.values());
        }
        return nextChild;
    }

    private void split(Node<T> node, Node<T> parent) {
        T c = node.removeValueAt(2);
        T b = node.removeValueAt(1);
        if (node == root) {
            root = new Node<>();
            root.addChild(node);
            parent = root;
        }
        parent.addValue(b);

        Node<T> brother = new Node<>();
        brother.addValue(c);
        if (!node.isLeaf()) {
            brother.addChild(node.removeChildAt(2));
            brother.addChild(node.removeChildAt(3));
        }
        parent.addChild(brother);
    }

}
