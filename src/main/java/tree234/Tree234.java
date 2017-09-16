package tree234;

public class Tree234<T> {

    private Node<T> root;

    public Tree234() {
        root = new Node<>();
    }

    public void insert(T value) {
        Node<T> next = root;
        do {
            if (next.isFull()) {
                split();
            }
        } while (!next.isLeaf());

    }

    private void split() {

    }

}
