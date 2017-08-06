package stacklist;

/**
 * Created by oleksandr on 04.07.17.
 */
public class BracketChecker {
    private String input;

    public void check() {
        Stack stack = new Stack(input.length());
        for (int i = 0; i < input.length(); i++) {
            char last = input.charAt(i);
            switch (last) {
                case '(':
                case '[':
                case '{':
                    stack.push(last);
                    break;
                case ')':
                case ']':
                case '}':
                    if (stack.isEmpty()) {
                        char pop = (char) stack.pop();
                        if (last == '}' && pop != '{' ||
                                last == ')' && pop != '(' ||
                                last == ']' && pop != '[') {
                            System.out.println("Error: " + last + " at " + i);
                        }
                    } else {
                        System.out.println("Error: Not enclosed bracket at " + i);
                    }
                    break;
            }
            if (!stack.isEmpty()) {
               System.out.println("Error: Missing right delimiter");
            }
        }
    }

}
