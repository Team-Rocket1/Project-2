public final class InfixToPostfix {
/*Algorithm from figure 5-9.*/
    private InfixToPostfix() {}

    public static String convertToPostfix(String infix) {
        LinkedStack<Character> operatorStack = new LinkedStack<>();
        StringBuilder postfix = new StringBuilder();

        int i = 0;
        while (i < infix.length()) {
            char ch = nextNonBlank(infix, i);

            while (i < infix.length() && Character.isWhitespace(infix.charAt(i))) i++;
            if (i >= infix.length() && Character.isWhitespace(ch)) break;
            if (i < infix.length()) ch = infix.charAt(i);

            if (isLetter(ch)) {
                postfix.append(ch);
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!operatorStack.isEmpty() &&
                       isOperator(operatorStack.peek()) &&
                       precedence(operatorStack.peek()) >= precedence(ch)) {
                    postfix.append(operatorStack.pop());
                }
                operatorStack.push(ch);
            } else if (ch == '(') {
                operatorStack.push(ch);
            } else if (ch == ')') {
                if (operatorStack.isEmpty())
                    throw new IllegalArgumentException("Mismatched parentheses: unexpected ')'");
                char top = operatorStack.pop();
                while (top != '(') {
                    postfix.append(top);
                    if (operatorStack.isEmpty())
                        throw new IllegalArgumentException("Mismatched parentheses: missing '('");
                    top = operatorStack.pop();
                }
            } else {

            }
            i++;
        }


        while (!operatorStack.isEmpty()) {
            char top = operatorStack.pop();
            if (top == '(' || top == ')')
                throw new IllegalArgumentException("Mismatched parentheses in input");
            postfix.append(top);
        }

        return postfix.toString();
    }

    private static boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static int precedence(char op) {
        switch (op) {
            case '+': case '-': return 1;
            case '*': case '/': return 2;
            default: return -1;
        }
    }

    private static char nextNonBlank(String s, int start) {
        for (int i = start; i < s.length(); i++) {
            if (!Character.isWhitespace(s.charAt(i))) return s.charAt(i);
        }
        return ' ';
    }
}
