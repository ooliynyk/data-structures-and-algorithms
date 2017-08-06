package tree234;

public class Tree234 {

    private static final int ITEM_A = 0;
    private static final int ITEM_B = 1;
    private static final int ITEM_C = 2;

    private Node root;

    public DataItem find(long key) {
        Node current = root;
        while (current.findItem(key) == -1 && !current.isLeaf()) {
            current = current.getNextChild(key);
            if (current.isFull()) {
                split(current);
            }
        }
        return null;
    }

    private void split(Node node) {
        Node newRight = new Node();

        Node parent = getOrCreateParentFor(node);
        parent.linkChildren(newRight);

        moveItemAt(ITEM_B, node, parent);

        moveItemAt(ITEM_C, node, newRight);

        moveChildrenAt(2, node, newRight);
        moveChildrenAt(3, node, newRight);
    }

    private Node getOrCreateParentFor(Node node) {
        Node parent;
        if (node == root) {
            parent = new Node();
            root = parent;
        } else {
            parent = node.getParent();
        }
        return parent;
    }

    private static void moveItemAt(int position, Node fromNode, Node toNode) {
        DataItem item = fromNode.popItemAt(position);
        toNode.insertItem(item);
    }

    private static void moveChildrenAt(int position, Node fromNode, Node toNode) {
        Node children = fromNode.popChildAt(position);
        toNode.linkChildren(children);
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }
}
