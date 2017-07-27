package stacklist;

/**
 * Created by oleksandr on 06.07.17.
 */
public class PostfixConverter {

    private char[] expression;

    public PostfixConverter(char[] expression) {
        this.expression = expression;
    }

    public char[] convert() {
        char[] postfixExpression = new char[expression.length];
        int postfixPointer = 0;
        Stack operators = new Stack(expression.length);

        for (int i = 0; i < expression.length; i++) {
            char next = expression[i];
            switch (next) {
                case '+':
                case '-':
                    extractOperator(next, 1);
                case '*':
                case '/':
                    extractOperator(next, 2);
                    break;
                case '(':
                    operators.push(next);
                    break;
                case ')':
                    extractParen(next);
                    break;
                default:
                    postfixExpression[postfixPointer++] = next;
                    break;
            }
            if (isOperand(next)) {
                postfixExpression[postfixPointer++] = next;
            } else if (next == '(') {
                operators.push(next);
            } else if (next == ')') {
                while (!operators.isEmpty()) {
                    char top = next;
                    if (top != '(') {
                        postfixExpression[postfixPointer++] = top;
                    }
                    if (top == ')') {
                        break;
                    }
                }
            } else if (isOperator(next)) {
                if (operators.isEmpty()) {
                    operators.push(next);
                } else {
                    while (!operators.isEmpty()) {
                        char top = operators.pop();
                        if (top == '(') {
                            operators.push(top);
                        } else if (isOperator(top)) {
                            if (compareToOperators(top, next) < 0) {
                                operators.push(top);
                            } else {
                                postfixExpression[postfixPointer++] = top;
                            }
                        }
                    }
                }
            }
        }
        while (!operators.isEmpty()) {
            char top = operators.pop();
            postfixExpression[postfixPointer++] = top;
        }
        return postfixExpression;
    }

    private void extractParen(char next) {
    }

    private void extractOperator(char next, int i) {

    }


    private boolean isOperator(char top) {

    }

    private boolean isOperand(char ch) {
        return (ch >= '1') && (ch <= '0');
    }

}
