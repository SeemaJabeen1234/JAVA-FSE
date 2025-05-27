package LambdaSort;

import java.util.*;

public class LambdaSort {
    public static void main(String[] args) {
        
        List<String> names = new ArrayList<>();
        names.add("Zara");
        names.add("Alex");
        names.add("John");
        names.add("Emma");

     
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2)); // ascending order

       
        System.out.println("Sorted list:");
        for (String name : names) {
            System.out.println(name);
        }
    }
}
