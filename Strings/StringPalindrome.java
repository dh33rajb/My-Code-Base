// Palindrome of a string
// My Best String Palindrome Algorithm

import java.util.*;
import java.lang.*;

public class StringPalindrome {
    public static void main (String args[]) {
        // Step-1: Read inputs
        Scanner scanner = new Scanner (System.in);
        String input = scanner.next();
        
        int i=0;
        int j = input.length() - 1;
        boolean flag = true;
        while (i<(input.length()/2)) {
            if (input.charAt(i) != input.charAt(j)) {
                flag= false;
                break;
            }
            i++;
            j--;
        }
        if (flag)
            System.out.println ("Palindrome");
        else
            System.out.println ("Not a Palindrome");
    }
}
