package Typecasting;

public class Typecasting {
    public static void main(String[] args) {
        // Widening Casting (int to double)
        int intVal = 42;
        double widenedVal = intVal; // Implicit casting
        System.out.println("Widening Casting (int to double): " + widenedVal);

        // Narrowing Casting (double to int)
        double doubleVal = 42.99;
        int narrowedVal = (int) doubleVal; // Explicit casting
        System.out.println("Narrowing Casting (double to int): " + narrowedVal);
    }
}
