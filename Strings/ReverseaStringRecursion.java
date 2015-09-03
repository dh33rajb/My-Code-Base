// Reverse a string using java
// Reverse a string using java

import java.util.*;
import java.lang.*;

public class ReverseaStringRecursion {
    public static void main (String args[]) {
        // Step-1
        Scanner scanner = new Scanner (System.in);
        String input = scanner.nextLine();
        
        // Step-2: Core logic
        String output = reverseString (input, 0);
        System.out.println ("Input String: " + input + " and Output String: " + output);
    }
    
    public static String reverseString (String input, int count) {
        if (input == null || input.length() < 2)
            return input;
        String output = "";
        if (count == (input.length()-1))
            return String.valueOf(input.charAt(count));
        output = reverseString (input, count + 1) + input.charAt(count);
        return output;
    }
    
}
