// find the point of rotation in sorted linked list

import java.util.*;
import java.lang.*;

class MiddleElementInRotatedSortedList {
  public static void main (String args[]) {
    System.out.println (findIndexOfRotation (new int[] {4, 5, 6, 1, 2, 3, 4}));
  }
  
  public static int findIndexOfRotation (int[] input) {
    // base case
    if (input == null || input.length == 0)
      return -1;
    return findIndexOfRotation (input, 0, input.length-1);
  }

  public static int findIndexOfRotation (int[] input, int start, int end) {
    // base and recursion condition
    if ((end-start) < 3) {
      for (int i=start+1; i <= end; i++) {
        if (input[i] < input[i-1])
          return (i);
      }
      return start;
    }
    // generic condition
    int mid = (start + end) / 2;
    if (input[mid] < input[mid-1] && input[mid] < input[mid+1])
      return mid;
    else if (input[mid] < input[start])
      return findIndexOfRotation (input, start, mid-1);
    else if (input[mid] > input[end])
      return findIndexOfRotation (input, mid+1, end);
    return start;
  }
}
