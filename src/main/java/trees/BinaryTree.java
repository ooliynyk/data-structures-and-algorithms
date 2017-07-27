package trees;

import lombok.Data;

public class BinaryTree {

    private Node root;

    public void insert(double element) {
        Node newNode = new Node(element);
        if (root != null) {
            Node current = root;
            while (true) {
                if (element < current.data) {
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

    public Node find(double key) {
        Node current = root;
        while (current != null && current.data != key) {
            if (key < current.data) {
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

    public boolean remove(double key) {
        if (root == null)
            return false;

        Node parentOfCurrent = null;
        Node current = root;
        boolean isLeftChild = false;
        while (current != null && current.data != key) {
            parentOfCurrent = current;
            if (key < current.data) {
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

    @Data
    private class Node {

        private double data;
        private Node leftChild;
        private Node rightChild;

        public Node(double element) {
            this.data = element;
        }
    }

    private class Iterator {
        private BinaryTree tree;
        private Node current;
        private Node parent;

        public Node next() {

            return current;
        }
    }

}
