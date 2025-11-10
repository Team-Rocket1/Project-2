public class DemoEvaluatePostfix {
public static void main(String[] args) {
        // Postfix expression Task 3 result //
        String postfix = "ab*ca-/de*+";


        // Variable Values given in Task 4 //
        int a = 2;
        int b = 3;
        int c = 4;
        int d = 5;
        int e = 6;


        int result = evaluatePostfix(postfix, a, b, c, d, e);


        // Display the result //
        System.out.println("_________________________________\n");
        System.out.println("Postfix expression: " + postfix + "\n");
        System.out.println("Variables: a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + ", e=" + e );
        System.out.println("_________________________________" + "\n");
        System.out.println("Result of postfix evaluation: " + result + "\n");
    }

    public static int evaluatePostfix(String postfix, int a, int b, int c, int d, int e) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
       
        for (char ch : postfix.toCharArray()) {
            if (ch >= 'a' && ch <= 'e') {
                switch (ch) {
                    case 'a': stack.push(a); break;
                    case 'b': stack.push(b); break;
                    case 'c': stack.push(c); break;
                    case 'd': stack.push(d); break;
                    case 'e': stack.push(e); break;
                }
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                switch (ch) {
                    case '+': stack.push(operand1 + operand2); break;
                    case '-': stack.push(operand1 - operand2); break;
                    case '*': stack.push(operand1 * operand2); break;
                    case '/': stack.push(operand1 / operand2); break;
                }
            }
        }
        return stack.pop();
    }

}
