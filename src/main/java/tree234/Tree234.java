package tree234;

public class Tree234 {

    private static final int ITEM_A = 0;
    private static final int ITEM_B = 1;
    private static final int ITEM_C = 2;

    private Node root;

    public Tree234() {
        root = new Node();
    }

    public void insert(DataItem item) {
        Node current = root;
        while (true) {
            if (current.isFull()) {
                split(current);
            }
            if (current.isLeaf()) {
                current.insertItem(item);
                break;
            } else {
                current = current.getNextChildBy(item);
            }
        }

    }

    private void split(Node splittable) {
        Node parent = getOrCreateParentFor(splittable);

        Node newRight = Node.newChildrenOf(parent);

        moveItemAt(ITEM_B, splittable, parent);

        moveItemAt(ITEM_C, splittable, newRight);

        moveLastChild(splittable, newRight);
        moveLastChild(splittable, newRight);
    }

    private Node getOrCreateParentFor(Node node) {
        Node parent;
        if (node == root) {
            parent = new Node();
            root = parent;
            parent.pushChild(node);
        } else {
            parent = node.getParent();
        }
        return parent;
    }

    private static void moveItemAt(int position, Node fromNode, Node toNode) {
        DataItem item = fromNode.popItemAt(position);
        toNode.insertItem(item);
    }

    private static void moveLastChild(Node fromNode, Node toNode) {
        Node child = fromNode.popChild();
        toNode.pushChild(child);
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }
}
