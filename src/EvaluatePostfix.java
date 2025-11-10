public class EvaluatePostfix {

    public static double evaluatePostfix(String postfix) {
        ResizableArrayStack<Double> valueStack = new ResizableArrayStack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char nextCharacter = postfix.charAt(i);

            if (Character.isDigit(nextCharacter)) {
                double value = Character.getNumericValue(nextCharacter);
                valueStack.push(value);
            }

            else if (nextCharacter == '+' || nextCharacter == '-' ||
                     nextCharacter == '*' || nextCharacter == '/' ||
                     nextCharacter == '^') {

                double operandTwo = valueStack.pop();
                double operandOne = valueStack.pop();
                double result = 0;

                switch (nextCharacter) {
                    case '+':
                        result = operandOne + operandTwo;
                        break;
                    case '-':
                        result = operandOne - operandTwo;
                        break;
                    case '*':
                        result = operandOne * operandTwo;
                        break;
                    case '/':
                        result = operandOne / operandTwo;
                        break;
                    case '^':
                        result = Math.pow(operandOne, operandTwo);
                        break;
                }

                valueStack.push(result);
            }
        }
        
        return valueStack.peek();
    }
}
