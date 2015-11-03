/* Given an array of integers write a function so that all the even numbers are on the left side of the array and all the odd numbers are on the right side of the array. */

import java.util.*;
import java.lang.*;

public class Solution {
  public static void main (String args[]) {
    System.out.println (Arrays.toString (evenToLeftOddToRight (new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9})));
  }
  
  public static int[] evenToLeftOddToRight (int[] input) {
    // base case
    if (input == null || input.length < 2)
      return input;

    // generic case
    int i = 0;
    int j = input.length - 1;

    while (i < j) {
      if (i % 2 == 0 && j % 2 != 0) {
        i++;
        j--;
      } else if (i % 2 == 0) {
        i++;
      } else if (j % 2 != 0) {
        j--;
      } else {
        int  temp = input [i];
        input [i] = input [j];
        input [j] = temp;
        i++;
        j--;
      }
    }
    return input;
  }  
}
