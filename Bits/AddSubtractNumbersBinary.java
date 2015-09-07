/* Add and Subtract two numbers using arithmetic operations */

// YET TO IMPLEMENT SUBTRACT

import java.util.*;
import java.lang.*;

public class AddSubtractNumbersBinary {
    public static void main (String args[]) {
        int num1 = 1; int num2 = 1;
        int sum = addNumbers(num1, num2);
        int sub = subtractNumbers (num1, num2);
        System.out.println (sum + "--" + sub);
    }
    
    public static int addNumbers (int num1, int num2) {
        int sum = 0; int carry = 0; int count = 0;
        // core logic
        while (num1 >0 | num2 >0) {
            sum =  ((num1 & 1) ^ (num2 & 1) | carry) << count | (sum);
            if (((num1 & 1) == 1) && ((num2 & 1) == 1))
                carry = 1;
            else
                carry = 0;
            num1 = num1 >> 1;
            num2 = num2 >> 1;
            count++;
        }
        carry = carry << count;
        sum = sum | carry;
        return sum;
    }
    
    public static int subtractNumbers (int num1, int num2) {
        return 0;
    }
}
