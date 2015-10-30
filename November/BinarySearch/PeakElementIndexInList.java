// find the peak element in a linkedlist that increases first and then decreases.
// elements are sorted

// Note: Only one peak exists, if at all there is one

import java.util.*;
import java.lang.*;

public class PeakElementIndexInList {
  public static void main (String args[]) {
    System.out.println (findPeakIndex (new int[] {5, 6, 7, 8, 4, 2, 1}));
  }
  
  public static int findPeakIndex (int[] input) {
    // base case
    if (input == null || input.length == 0)
      return -1;
    // generic case
    return findPeakIndex (input, 0, input.length-1);
  }

  public static int findPeakIndex (int[] input, int start, int end) {
    // base case or recursion end case
    if ((end - start) <= 2) {
      for (int i= start+1; i <= end; i++) {
        if (input[i] < input[i-1])
          return (i-1);
      }
      return end;
    }

    // generic case
    int mid = (start + end) / 2;

    if (input[mid] > input[mid+1] && input[mid] > input[mid-1])
      return mid;
    else if (input[mid] > input[mid-1])
      return findPeakIndex (input, mid+1, end);
    else if (input[mid] < input[mid-1])
      return findPeakIndex (input, start, mid-1);
    else
      return start;
  }
}
