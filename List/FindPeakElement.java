// given a list, such that the list is increasing and then suddently starts decreasign.. find the peak element
/*
Input:
-----
5  6  7  8  9  12  11  10  9  7  4  2

Output:
-------
12

*/

import java.io.*;
import java.util.*;

public class FindPeakElement {
  public static void main(String[] args) {
    int[] input = {5, 6, 7, 8, 9, 12, 11, 10, 9, 7, 4, 2};
    int peak = findPeak (input, 0, input.length-1);
    System.out.println (peak);
  }
  
  public static int findPeak (int[] input, int start, int end) {
    System.out.println (start + "--" + end);
    if (start == end)
      return input[start];
    int peak = 0;
    int mid = (start + end) /2;
    if (mid > start) {
      // compare mid and mid-1
      if (input[mid] < input[mid-1]) {
        // select left half for recursion
        peak = findPeak (input, start, mid);
      } else {
        // select right half for recursion
        peak = findPeak (input, mid, end);
      }
    } else {
      return Math.max (input[start], input[end]);
    }
    return peak;
  }
}
