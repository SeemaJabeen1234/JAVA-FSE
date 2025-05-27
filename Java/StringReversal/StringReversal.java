package StringReversal;
import java.util.Scanner;

public class StringReversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        StringBuilder reversed = new StringBuilder(input).reverse();

        // Display the reversed string
        System.out.println("Reversed using StringBuilder: " + reversed);

        // Method 2: Using loop
        String reversedLoop = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversedLoop += input.charAt(i);
        }

        System.out.println("Reversed using loop: " + reversedLoop);
        scanner.close();
    }
}
