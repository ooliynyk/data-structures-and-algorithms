package trees;


import java.util.*;

public class HuffmanEncoder {
    private String[] codeTable;
    private String message;
    private BinaryTree messageTree;

    public HuffmanEncoder(String message) {
        this.message = message;
        codeTable = new String[28];
        messageTree = new BinaryTree();
    }

    public String[] encode() {
        return null;
    }

    public String decode(String[] encodedMessage) {
        return null;
    }

    private class HuffmanTree {
        private String message;

        public HuffmanTree(String message) {
            this.message = message;
        }

        public BinaryTree buildTree() {
            Set<Character> symbols = new HashSet<>();
            for (int i = 0; i < message.length(); i++) {
                symbols.add(message.charAt(i));
            }

            for (Character symbol : symbols) {
                BinaryTree tree = new BinaryTree();
                tree.insert(symbol, occurrencesOfSymbol(symbol));
            }

            return null;
        }

        private long occurrencesOfSymbol(char symbol) {
            return message.chars().filter(num -> num == symbol).count();
        }

    }

}
