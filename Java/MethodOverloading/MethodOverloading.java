package MethodOverloading;
//same function name but different parameters

public class MethodOverloading {

    public static int add(int a, int b) {
        return a + b;
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {

        int sum1 = add(5, 10); // Two integers
        double sum2 = add(3.5, 2.5); // Two doubles
        int sum3 = add(1, 2, 3); // Three integers

        System.out.println("Sum of two integers: " + sum1);
        System.out.println("Sum of two doubles: " + sum2);
        System.out.println("Sum of three integers: " + sum3);
    }
}
