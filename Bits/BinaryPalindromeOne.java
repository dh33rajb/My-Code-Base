/* Bits & Bytes: Find if a binary representation of a number is palindrome. The function should work irrespective of number of bytes for an integer. Suppose if our machine is 4 bytes for an int, how will you use the program for 8 byte machine. */

import java.util.*;
import java.lang.*;

public class BinaryPalindromeOne {
    public static void main (String args[]) {
        // Step-1: Reading inputs
        int inputOne = 10;
        int inputTwo = 9;
        
        // Step-2: Convert binary to string using Integer radix
        String stringOne = Integer.toString(inputOne, 2);
        String stringTwo = Integer.toString(inputTwo, 2);
        
        // Step-3: Check if string is a palindrome
        System.out.println ("Is " + inputOne + " a Binary palindrome?: " + isBinaryPalindrome (stringOne));
        System.out.println ("Is " + inputTwo + " a Binary palindrome?: " + isBinaryPalindrome(stringTwo));
    }
    
    public static boolean isBinaryPalindrome (String input) {
        int i=0;
        int j=input.length()-1;
        boolean flag = true;
        while (i <= j) {
            if (input.charAt (i) != input.charAt (j)) {
                flag = false;
                break;
            }
            i++;
            j--;
        }
        return flag;
    }
}
