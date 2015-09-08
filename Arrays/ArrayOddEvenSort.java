//Given an array with unsorted integers, move all even on left side and all odds on right side. After that sort even in increasing order and sort odd in decreasing order
/*
Input (hardcoded for simplicty):
------
4, 7, 8, 2, 9, 1, 6, 3, 5, 15, 11

Output:
------
2-4-6-8------15-11-9-7-5-3-1
*/

import java.util.*;
import java.lang.*;

public class ArrayOddEvenSort {
  public static void main (String args[]) {
    // Step-1: Define inputs - hardcoding for simplicity
    final int[] input = new int [] {4, 7, 8, 2, 9, 1, 6, 3, 5, 15, 11};
    
    // Step-2: Swap odd and even places
    int breakerIndex = evenToStartAndOddToEndArray(input);
    for (int i : input)
      System.out.print (i + "-");
    System.out.println(breakerIndex);
    
    // Step-3: quick sort routine for each of odd and even numbers
    quickSortArrayIncr (input, 0, breakerIndex - 1, true);
    quickSortArrayIncr (input, breakerIndex, input.length-1, false);
    for (int i : input)
      System.out.print (i + "-");
    System.out.println();
  }
  
  public static int evenToStartAndOddToEndArray (int[] input) {
    int i=0;
    int j = input.length-1;
    while (i < j) {
      if (input[i] % 2 != 0 && input[j]%2 == 0) {
        int temp = input[i];
        input[i]=input[j];
        input[j]=temp;
        i++; j--;
      }
      if (input[i] %2 == 0)
        i++;
      if (input[j] %2 != 0)
        j--;
    }
    return i;
  }
  
  public static void quickSortArrayIncr (int[] input, int startIndex, int endIndex, boolean flag) {
    if (startIndex >= endIndex)
      return;
    int pivot = endIndex;
    int wall = startIndex;
    for (int i=startIndex; i< endIndex; i++) {
      if (flag && input[i] < input[pivot]) {
        int temp = input[i];
        input[i] = input[wall];
        input[wall] = temp;
        wall++;
      } else if (!flag && input[i] > input[pivot]) {
        int temp = input[i];
        input[i] = input[wall];
        input[wall] = temp;
        wall++;
      }
    }
    int temp = input[pivot];
    input[pivot] = input[wall];
    input[wall] = temp;
    quickSortArrayIncr(input, startIndex, wall-1, flag);
    quickSortArrayIncr(input, wall+1, endIndex, flag);
  }
}
