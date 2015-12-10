import java.util.*;
import java.lang.*;

public class HappyNumbers {
    public boolean isHappy(int n) {
        if (n == 0)
            return false;
        else if (n == 1)
            return true;
        // generic case
        else {
            List<Integer> list = new ArrayList<Integer> ();
            // Step-1: Logic to split out individual digits and add to a list
            do {
                int quo = n / 10;
                int rem = n % 10;
                list.add (rem);
                n = quo;
            } while (n > 0);
            
            // Step-4: core logic
            int output = sumOfSquares (list);
            System.out.println (output);
            if (output == 1)
                return true;
            else if (output < 9)
                return false;
            else
                return isHappy (output);
        }
    }
    
    // Step-2: Find the square of a number
    public int findSquare (int n) {
        return (n * n);
    }
    
    // Step-3: Find the sum of squares of a list of numbers
    public int sumOfSquares (List<Integer> list) {
        if (list == null || list.size() ==0)
            return 0;
        else {
            int sum = 0;
            for (int i : list) {
                sum = sum + findSquare (i);
            }
            return sum;
        }
    }
}
