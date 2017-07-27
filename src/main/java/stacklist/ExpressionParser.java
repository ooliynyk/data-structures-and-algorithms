package stacklist;

/**
 * Created by oleksandr on 09.07.17.
 */
public class ExpressionParser {
    public double calculate(char[] input) {
        Stack stack = new Stack(input.length);
        for (char ch : input) {
            if (ch >= '0' && ch <= '9') {
                stack.push(ch - '0');
            } else {
                int val1 = stack.pop();
                int val2 = stack.pop();
                int partialResult;
                switch (ch) {
                    case '*':
                        partialResult = val1 * val2;
                        break;
                    case '/':
                        partialResult = val1 / val2;
                        break;
                    case '+':
                        partialResult = val1 + val2;
                        break;
                    case '-':
                        partialResult = val1 - val2;
                        break;
                    default:
                        partialResult = 0;
                }
                stack.push(partialResult);
            }
        }
        return stack.pop();
    }
}
