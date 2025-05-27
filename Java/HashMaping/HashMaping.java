package HashMaping;
import java.util.HashMap;
import java.util.Scanner;

public class HashMaping {
    public static void main(String[] args) {
        HashMap<Integer, String> studentMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int id;
        String name;
        char choice;

     
        do {
            System.out.print("Enter student ID (integer): ");
            id = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Enter student name: ");
            name = scanner.nextLine();

            studentMap.put(id, name);

            System.out.print("Do you want to add another entry? (y/n): ");
            choice = scanner.nextLine().charAt(0);
        } while (choice == 'y' || choice == 'Y');

      
        System.out.print("\nEnter an ID to search for the student name: ");
        int searchId = scanner.nextInt();
        if (studentMap.containsKey(searchId)) {
            System.out.println("Student Name: " + studentMap.get(searchId));
        } else {
            System.out.println("Student ID not found.");
        }

        scanner.close();
    }
}
