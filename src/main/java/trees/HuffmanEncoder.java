package trees;


import stacklist.PriorityQueue;

import java.util.*;

public class HuffmanEncoder {
    private String[] codeTable;
    private String message;
    private PriorityQueue<HuffmanTree> queue;
    private HuffmanTree tree;

    public HuffmanEncoder(String message) {
        this.message = message;
        codeTable = new String[28];
        queue = new PriorityQueue<>(message.length());
        tree = buildTree();
        createCodeTable(tree.root(), "");
    }

    public String[] encode() {
        String[] encodedMessage = new String[message.length()];
        for (int i = 0; i < message.length(); i++) {
            int positionOfCodeTable = findPosition(message.charAt(i));
            encodedMessage[i] = codeTable[positionOfCodeTable];
        }
        return encodedMessage;
    }

    public String decode(String[] encodedMessage) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < encodedMessage.length; i++) {
            String code = encodedMessage[i];

            Node current = buildTree().root();
            for (char ch : code.toCharArray()) {
                if (ch == '0') {
                    current = current.leftChild;
                } else {
                    current = current.rightChild;
                }
            }
            sb.append(current.symbol);
        }
        return sb.toString();
    }

    private void createCodeTable(Node node, String value) {
        if (node.leftChild == null && node.rightChild == null) {
            int position = findPosition(node.symbol);
            codeTable[position] = value;
            return;
        }

        createCodeTable(node.leftChild, value + "0");
        createCodeTable(node.rightChild, value + "1");
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

    private static int findPosition(char symbol) {
        int position;
        switch (symbol) {
            case '\n':
                position = 26;
                break;
            case ' ':
                position = 27;
                break;
            default:
                position = symbol - 'A';
                break;
        }
        return position;
    }

}
