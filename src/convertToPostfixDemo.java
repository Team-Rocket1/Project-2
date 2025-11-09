public class convertToPostfixDemo {
    public static void main(String[] args) {
        // Expression given in Task 1 //
        String infix = "a*b/(c-a)+d*e";

        // Convert infix to postfix //
        String postfix = InfixToPostfix.convertToPostfix(infix);

        // Printing the results //
        System.out.println("_____________________________________" + "\n");
        System.out.println("Converting Infix to Postfix:");
        System.out.println("____________________________________" + "\n");
        System.out.println("Infix Expression: " + infix + "\n");
        System.out.println("Postfix Expression: " + postfix + "\n");

    }
}