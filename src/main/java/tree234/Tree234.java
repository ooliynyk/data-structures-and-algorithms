package tree234;

public class Tree234 {
    private Node root;

    public DataItem find(long key) {
        Node current = root;
        while (current.findItem(key) == -1 && !current.isLeaf()) {
            current = current.getNextChild(key);
            if (current.isFull()) {

            }
        }
        return null;
    }

    private void split(Node node) {
        DataItem itemB = node.popItemAt(1);
        DataItem itemC = node.popItemAt(2);

    }

    public static void main(String[] args) {
        System.out.println("hello");
    }
}
