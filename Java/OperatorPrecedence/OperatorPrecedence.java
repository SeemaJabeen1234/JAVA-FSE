package OperatorPrecedence;

public class OperatorPrecedence {
    public static void main(String[] args) {
        int a = 10 + 5 * 2; // Multiplication has higher precedence than addition
        int b = (10 + 5) * 2; // Parentheses change the order of operations
        int c = 20 / 5 + 3 * 2; // Division and multiplication first, then addition
        int d = 20 / (5 + 3) * 2; // Parentheses change order again

        System.out.println("a = 10 + 5 * 2 = " + a); // Output: 20
        System.out.println("b = (10 + 5) * 2 = " + b); // Output: 30
        System.out.println("c = 20 / 5 + 3 * 2 = " + c); // Output: 10
        System.out.println("d = 20 / (5 + 3) * 2 = " + d); // Output: 4
    }
}
