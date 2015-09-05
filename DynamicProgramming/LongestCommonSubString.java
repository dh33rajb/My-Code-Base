// LONGEST COMMON SUB String
/*
Input (Hardcoded for simplicity):
abcdefghijk & abzdefxghijk

Output:
ghijk
*/
import java.io.*;
import java.util.*;

public class LongestCommonSubString {
  public static void main(String[] args) {
    
    // Step-1: Define inputs
    String stringOne = "abcdefghijk";
    String stringTwo = "abzdefxghijk";
    int[][] matrix = new int[stringOne.length()][stringTwo.length()];
    int indexOfMaxNumberS1 = 0;
    int sumofMaxNumber = 0;
    // Step-2: Populate matrix
    for (int i=0; i < stringOne.length(); i++) {
      for (int j=0; j < stringTwo.length(); j++) {
        if (stringOne.charAt(i) == stringTwo.charAt(j)) {
          if (i!=0 && j!=0) {
            matrix[i][j] = matrix[i-1][j-1] + 1;
            if (matrix[i][j] > sumofMaxNumber) {
              sumofMaxNumber = matrix[i][j];
              indexOfMaxNumberS1 = i;
            }
          }
          else
            matrix[i][j] = 1;
        } else {
          matrix[i][j] = 0;
        }
      }
    }
    
    // Step-3: Get the longest sub string
    String output = "";
    for (int i=stringOne.length()-1; i>=0; i--) {
      if (i==indexOfMaxNumberS1) {
        while (sumofMaxNumber-- >0)
          output = stringOne.charAt(i--) + output;
        break;
      }
    }
    System.out.println (output);
  }
}
