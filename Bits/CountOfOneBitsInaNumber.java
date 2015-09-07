// HOW MANY BINARY ONES ARE THERE IN A GIVEN NUMBER --> BOTH POSITIVE AND NEGATIVE NUMBERS
// PERFECT SOLUTION (IMPLEMENTED IN TWO WAYS)

/*
Input (Hardcoded):
-----------------
  int positiveInput = 6;
  int negativeInput = -1;

Output:
------
2--32 ==> Ordinary manual mentod
2--32 ==> Trick method

*/

import java.util.*;
import java.lang.*;

public class CountOfOneBitsInaNumber {
  public static void main (String args[]) {
    int positiveInput = 6;
    int negativeInput = -1;
    System.out.println (Integer.toBinaryString(negativeInput));
    
    int positiveResult = countOnesBinary (positiveInput);
    int negativeResult = countOnesBinary (negativeInput);
    System.out.println (positiveResult + "--" + negativeResult);
    
    positiveResult = countOnesBinaryOptimized (positiveInput);
    negativeResult = countOnesBinaryOptimized (negativeInput);
    System.out.println (positiveResult + "--" + negativeResult);
  }
  
  public static int countOnesBinaryOptimized (int number) {
    int count = 0;
    while (number != 0) {
      count++;
      number = number & (number - 1);
    }
    return count;
  }
  
  public static int countOnesBinary (int number) {
    int count = 0;
    if (number > 0) { // positive number
      while (number > 0){
        if ((number & 1) == 1)
          count++;
        number >>= 1;
      }
    } else { // negative number
      int flag = 1;
      count++; // we are initializing count to 1 because the flag is  when we start with. this adds up.
      while (flag != 0) {
        if ((number & flag) > 0)
          count++;
        flag <<= 1;
      }
    }
    return count;
  }
}
