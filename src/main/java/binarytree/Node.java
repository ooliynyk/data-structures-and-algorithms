package binarytree;

import lombok.Data;

@Data
public class Node {

    char symbol;
    long occurrences;
    Node leftChild;
    Node rightChild;

    public Node(char symbol, long occurrences) {
        this.symbol = symbol;
        this.occurrences = occurrences;
    }

}