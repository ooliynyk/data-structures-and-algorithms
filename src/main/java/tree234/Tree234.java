package tree234;

public class Tree234 {
    private Node root;

    public DataItem find(long key) {
        Node current = root;
        while (current.findItem(key) == -1 && !current.isLeaf()) {
            current = current.getNextChild();
        }
    }
}
