// String anagram

import java.util.*;
import java.lang.*;


public class FibonnacciSeriesAndNumber {
  public static void main (String args[]) {
    System.out.println (Arrays.toString (fetchFibonnacciSeries(10)));
    System.out.println (fetchFibonnacciNumber (10));
  }
  
  public static int[] fetchFibonnacciSeries (int n) {
    // base case
    if (n < 1)
      return new int[1];

    // generic case
    int[] output = new int [n];
    output[0] = 0;
    output[1] = 1;

    for (int i=2; i < n; i++)
      output[i] = output[i-1] + output[i-2];

    return output;
  }
  
  public static int fetchFibonnacciNumber (int n) {
    // base case
    if (n < 1)
      return 0;
    else if (n==1)
      return 0;
    else if (n==2)
      return 1;
    
    // generic case
    int[] fib = new int[2];
    fib[0] = 0;
    fib[1] = 1;
    
    for (int i=2; i < n; i++) {
      int temp = fib[0];
      fib[0] = fib[1];
      fib[1] = temp + fib[1]; 
    }
    return fib[1];
  }
}
