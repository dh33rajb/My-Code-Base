// Find if a number is a negative number

import java.util.*;
import java.lang.*;

public class IsNumberNegative {
    public static void main (String args[]) {
        long num1 = -55555;
        long num2 = -1;
        
        double dou1 = 345.657;
        double dou2 = -5678.8997;
        System.out.println (isNumberNegative (num1) + "--" + isNumberNegative (num2));
        System.out.println (isDoubleNegative (dou1) + "--" + isDoubleNegative (dou2));
    }
    
    public static boolean isNumberNegative (long num) {
        if (num >> 63 == 0) // if int, then we shift by 31
            return false;
        else
            return true;
    }
    
    public static boolean isDoubleNegative (double num) {
        if ((num * Double.POSITIVE_INFINITY) == Double.POSITIVE_INFINITY)
            return false;
        else
            return true;
    }
}
