// FindLoneNonRepeatedElement

/*
Input:
-----
int input[] = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9};

Output:
------
9
*/

import java.io.*;
import java.util.*;

class FindLoneNonRepeatedElement {
  public static void main(String[] args) {
    // Step-1: Inputs
    int input[] = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9};
    
    int loneElement = findTheLoneElement (input, 0, input.length-1);
    System.out.println (loneElement);
  }
  
  public static int findTheLoneElement (int[] input, int start, int end) {
    int result = -1;
    // Imposible case
    if (end <= start) {
      return -1;
    }
    // base case
    if (end - start == 2) {
      if (input[start] == input[start+1]){
        return input[end];
      }
      else
        return input[start];
      
    }
    // generic case
    int mid = (start + end) / 2;
    System.out.println (start + "--" + mid + "--"+ end);
    if (input[mid] != input [mid-1] && input[mid] != input[mid+1])
      return input[mid];
    else {
      if (input[end] % 2 != 0) {
        if (input[mid] == input[mid-1])
          result = findTheLoneElement (input, start, mid);
        else
          result = findTheLoneElement (input, mid, end);
      } else{
        if (input[mid] == input[mid-1])
          result = findTheLoneElement (input, mid+1, end);
        else
          result = findTheLoneElement (input, start, mid-1);
      }
    }
    return result;
  }
}
