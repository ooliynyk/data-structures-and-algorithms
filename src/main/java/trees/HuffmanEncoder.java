package trees;


import stacklist.PriorityQueue;

import java.util.*;

public class HuffmanEncoder {
    private String[] codeTable;
    private String message;
    private PriorityQueue<HuffmanTree> queue;

    public HuffmanEncoder(String message) {
        this.message = message;
        codeTable = new String[28];
        queue = new PriorityQueue<>(message.length());
    }

    private HuffmanTree buildTree() {
        Set<Character> symbols = new HashSet<>();
        for (int i = 0; i < message.length(); i++) {
            symbols.add(message.charAt(i));
        }

        for (Character symbol : symbols) {
            HuffmanTree tree = new HuffmanTree(symbol, occurrencesOfSymbol(symbol));
            queue.insert(tree);
    }

        while (queue.size() > 1) {
            HuffmanTree firstTree = queue.remove();
            HuffmanTree secondTree = queue.remove();

            HuffmanTree newTree = HuffmanTree.of(firstTree, secondTree);
            queue.insert(newTree);
        }

        return queue.remove();
    }

    private long occurrencesOfSymbol(char symbol) {
        return message.chars().filter(num -> num == symbol).count();
    }

    public String[] encode() {
        HuffmanTree tree = buildTree();
        tree.display();
        return null;
    }

    public String decode(String[] encodedMessage) {
        return null;
    }

}
