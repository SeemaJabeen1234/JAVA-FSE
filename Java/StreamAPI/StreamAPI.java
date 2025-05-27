package StreamAPI;

import java.util.*;
import java.util.stream.Collectors;

public class StreamAPI {
    public static void main(String[] args) {
       
        List<Integer> numbers = Arrays.asList(10, 15, 22, 33, 40, 55, 60);

        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        
        System.out.println("Even numbers: " + evenNumbers);
    }
}
