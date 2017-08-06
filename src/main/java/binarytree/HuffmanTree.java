package binarytree;


public class HuffmanTree implements Comparable<HuffmanTree> {
    private final long occurrences;
    private final Node root;

    public HuffmanTree(char symbol, long occurrences) {
        root = new Node(symbol, occurrences);
        this.occurrences = occurrences;
    }

    public static HuffmanTree of(HuffmanTree first, HuffmanTree second) {
        long firstOccurrences = first.occurrences;
        long secondOccurrences = second.occurrences;
        long totalOccurrences = firstOccurrences + secondOccurrences;

        HuffmanTree tree = new HuffmanTree('\r', totalOccurrences);
        if (firstOccurrences < secondOccurrences) {
            tree.root.leftChild = first.root;
            tree.root.rightChild = second.root;
        } else {
            tree.root.leftChild = second.root;
            tree.root.rightChild = first.root;
        }

        return tree;
    }

    public Node root() {
        return root;
    }

    public void display() {
        display(root);
    }

    private void display(Node node) {
        if (node == null)
            return;

        display(node.leftChild);

        if (node.symbol != '\r')
            System.out.printf("%c : %d\n", node.symbol, node.occurrences);

        display(node.rightChild);
    }

    @Override
    public int compareTo(HuffmanTree o) {
        return (occurrences < o.occurrences) ? 1 :
                (occurrences > o.occurrences) ? -1 : 0;
    }

}