/* FIND IF A NUMBER IS A POWER OF 2
Ex: 
---
2,4,8,16,32.. are powers of two ==> return true
1,6,12.. are not powers of two ==> return false
*/
import java.util.*;
import java.lang.*;

public class IsNumberPowerOfTwo {
  public static void main (String args[]) {
    int yesInput = 32;
    int noInput = 12;
    boolean yesResult = isPowerOfTwo (yesInput);
    boolean noResult = isPowerOfTwo (noInput);
    System.out.println (yesResult + "-" + noResult);
  }
  public static boolean isPowerOfTwo (int number) {
    int count = 0;
    while (number > 0) {
      number = number & (number -1);
      count++;
    }
    if (count == 1)
      return true;
    else
      return false;
  }
}
