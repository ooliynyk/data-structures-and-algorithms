package trees;

public class BinaryTree  {

    private Node root;

    public void insert(char symbol, long occurrences) {
        Node newNode = new Node(symbol, occurrences);
        if (root != null) {
            Node current = root;
            while (true) {
                if (occurrences < current.occurrences) {
                    if (current.leftChild == null) {
                        current.leftChild = newNode;
                        return;
                    }
                    current = current.leftChild;
                } else {
                    if (current.rightChild == null) {
                        current.rightChild = newNode;
                        return;
                    }
                    current = current.rightChild;
                }
            }
        } else {
            root = newNode;
        }
    }

    public Node find(int key) {
        Node current = root;
        while (current != null && current.occurrences != key) {
            if (key < current.occurrences) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
        }
        return current;
    }

    public Node min() {
        if (root == null)
            return null;

        Node current = root;
        while (current.leftChild != null) {
            current = current.leftChild;
        }

        return current;
    }

    public boolean remove(int key) {
        if (root == null)
            return false;

        Node parentOfCurrent = root;
        Node current = root;
        boolean isLeftChild = false;
        while (current != null && current.occurrences != key) {
            parentOfCurrent = current;
            if (key < current.occurrences) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
        }

        if (current != null) {
            if (current.leftChild == null && current.rightChild == null) {
                if (current == root) {
                    root = null;
                } else if (isLeftChild) {
                    parentOfCurrent.leftChild = null;
                } else {
                    parentOfCurrent.rightChild = null;
                }
            } else if (current.leftChild == null) {
                if (current == root) {
                    root = current.rightChild;
                } else if (isLeftChild) {
                    parentOfCurrent.leftChild = current.rightChild;
                } else {
                    parentOfCurrent.rightChild = current.rightChild;
                }
            } else if (current.rightChild == null) {
                if (current == root) {
                    root = current.leftChild;
                } else if (isLeftChild) {
                    parentOfCurrent.leftChild = current.leftChild;
                } else {
                    parentOfCurrent.rightChild = current.leftChild;
                }
            } else {
                Node successor = getSuccessor(current);

                if (current == root) {
                    root = successor;
                } else if (isLeftChild) {
                    parentOfCurrent.leftChild = successor;
                } else {
                    parentOfCurrent.rightChild = successor;
                }
                successor.leftChild = current.leftChild;
            }
            return true;
        }

        return false;
    }

    private Node getSuccessor(Node current) {
        Node parentOfSuccessor = current.rightChild;
        Node successor = current.rightChild;
        while (parentOfSuccessor.leftChild != null) {
            parentOfSuccessor = successor;
            successor = parentOfSuccessor.leftChild;
        }

        if (successor != current.rightChild) {
            parentOfSuccessor.leftChild = successor.rightChild;
            successor.rightChild = current.rightChild;
        }
        return successor;
    }

    public void iterate() {
        iterate(root);
    }

    private void iterate(Node root) {
        if (root == null)
            return;

        iterate(root.leftChild);
        System.out.println(root);
        iterate(root.rightChild);
    }

}
