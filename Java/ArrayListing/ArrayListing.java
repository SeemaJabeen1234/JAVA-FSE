package ArrayListing;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListing {
    public static void main(String[] args) {
        ArrayList<String> studentNames = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String name;
        char choice;

        do {
            System.out.print("Enter student name: ");
            name = scanner.nextLine();
            studentNames.add(name);

            System.out.print("Do you want to add another name? (y/n): ");
            choice = scanner.nextLine().charAt(0);
        } while (choice == 'y' || choice == 'Y');

        System.out.println("\nList of Student Names:");
        for (String student : studentNames) {
            System.out.println(student);
        }

        scanner.close();
    }
}
