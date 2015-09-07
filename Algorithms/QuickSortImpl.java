// QUICK SORT IN JAVA

/*
Input (hardcoded for simplicity):
------
4, 7, 8, 2, 9, 1, 6, 3, 5, 15, 1

Output:
-------
1-2-3-4-5-6-7-8-9-11-15-
*/
import java.util.*;
import java.lang.*;

public class QuickSortImpl {
  public static void main (String args[]) {
    // Step-1: Define inputs - hardcoding for simplicity
    final int[] input = new int [] {4, 7, 8, 2, 9, 1, 6, 3, 5, 15, 11};
    quickSortArray (input, 0, input.length-1);
    for (int i : input)
      System.out.print (i + "-");
    System.out.println();
  }
  
  public static void quickSortArray (int[] input, int startIndex, int endIndex) {
    if (startIndex >= endIndex)
      return;
    int pivot = endIndex;
    int wall = startIndex;
    for (int i=startIndex; i< endIndex; i++) {
      if (input[i] < input[pivot]) {
        int temp = input[i];
        input[i] = input[wall];
        input[wall] = temp;
        wall++;
      }
    }
    int temp = input[pivot];
    input[pivot] = input[wall];
    input[wall] = temp;
    quickSortArray(input, startIndex, wall-1);
    quickSortArray(input, wall+1, endIndex);
  }
}
