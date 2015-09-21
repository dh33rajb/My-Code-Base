// MY ULTIMATE PROGRAM TO REVERSE A STRING.. LOL

// Reverse a string using java
// Reverse a string using java

import java.util.*;
import java.lang.*;

public class Solution {
    public static void main (String args[]) {
        // Step-1: Read inputs
        String input = "uber-eats";
        
        // Step-2: Reversing a string using RECURSION
        String output = reverseStringRecursion (input, 0);
        System.out.println ("Input String: " + input + " and Output String: " + output);
      
      // Step-3: Reversing a string IN-PLACE (NO RECURSION)
      String output2 = reverseStringInPlace (input.toCharArray());
      System.out.println ("Input String: " + input + " and Output String: " + output2);
      
    }
    
    // Function to reverse a string using RECURSION --> Time: O(n) | Space: O(n)
    public static String reverseStringRecursion (String input, int count) {
        if (input == null || input.length() < 2)
            return input;
        String output = "";
        if (count == (input.length()-1))
            return String.valueOf(input.charAt(count));
        output = reverseStringRecursion (input, count + 1) + input.charAt(count);
        return output;
    }
  
    // Function to reverse a string IN-PLACE --> Time O(n) | Space: O(1)
    public static String reverseStringInPlace (char[] inputArr) {
        int length = inputArr.length;
        for (int i=0 ; i < length/2; i++) {
          char temp = inputArr[i];
          inputArr[i] = inputArr[(length-1)-i];
          inputArr[(length-1)-i] = temp;
        }
        return String.valueOf(inputArr);
    }
}
