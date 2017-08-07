package tree234;

public class Tree234 {

    private static final int ITEM_A = 0;
    private static final int ITEM_B = 1;
    private static final int ITEM_C = 2;

    private Node root;

    public Tree234() {
        root = new Node();
    }

    public DataItem insert(DataItem item) {
        Node current = root;
        while (current.findItem(item) == -1 && !current.isLeaf()) {
            current = current.getNextChildrenBy(item);
            if (current.isFull()) {
                split(current);
            } else if (current.isLeaf()) {
                current.insertItem(item);
            }
        }
        return null;
    }

    private void split(Node splittable) {
        Node parent = getOrCreateParentFor(splittable);

        Node newRight = Node.newChildrenOf(parent);

        moveItemAt(ITEM_B, splittable, parent);

        moveItemAt(ITEM_C, splittable, newRight);

        moveChildrenAt(2, splittable, newRight);
        moveChildrenAt(3, splittable, newRight);
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
