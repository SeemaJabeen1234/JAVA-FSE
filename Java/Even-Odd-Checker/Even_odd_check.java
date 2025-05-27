import java.util.Scanner;
public class Even_odd_check {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an Integer:");
        int number = scanner.nextInt();
        if(number%2==0)
        {
            System.out.print(number + " is Even");
        }
        else
        {
            System.out.print(number + " is Odd");
        }
        scanner.close();
    }
}