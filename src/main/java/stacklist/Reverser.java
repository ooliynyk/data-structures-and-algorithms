package stacklist;

/**
 * Created by oleksandr on 04.07.17.
 */
public class Reverser {
    private String input;

    public Reverser(String input) {
        this.input = input;
    }

    public String reverse() {
        Stack stack = new Stack(input.length());
        for (char symbol : input.toCharArray()) {
            stack.push(symbol);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
