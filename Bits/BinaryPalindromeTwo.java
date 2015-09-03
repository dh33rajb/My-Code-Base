/* Bits & Bytes: Find if a binary representation of a number is palindrome. The function should work irrespective of number of bytes for an integer. Suppose if our machine is 4 bytes for an int, how will you use the program for 8 byte machine.
Output:
Is 717 a Binary palindrome?: true
Is 313 a Binary palindrome?: true
*/

import java.util.*;
import java.lang.*;

public class BinaryPalindromeTwo {
    public static void main (String args[]) {
        // Step-1: Reading inputs
        int inputOne = 717;
        int inputTwo = 313;
        
        // Step-2: Check if string is a palindrome
        System.out.println ("Is " + inputOne + " a Binary palindrome?: " + isBinaryPalindrome (inputOne));
        System.out.println ("Is " + inputTwo + " a Binary palindrome?: " + isBinaryPalindrome(inputTwo));
    }
    
    public static boolean isBinaryPalindrome (int input) {
        int copy = input;
        int num3 = copy & 1;
        while ((copy >> 1) != 0) {
            copy = copy >> 1;
            int num2 = copy & 1;
            num3 = (num3 << 1) | num2;
        }
        return (input == num3);
    }
}
