// SPIRAL SQUARE MATRIX
/*
Input:
-----
0  1  2  3  4  
5  6  7  8  9  
10  11  12  13  14  
15  16  17  18  19  
20  21  22  23  24  

Output:
------
[0, 1, 2, 3, 4, 9, 14, 19, 24, 23, 22, 21, 20, 15, 10, 5, 6, 7, 8, 13, 18, 17, 16, 11, 12]
*/

import java.util.*;
import java.lang.*;

public class SpiralSquareMatrixPrint {
  public static void main (String args[]) {
    int rows = 4; int counter=0;
    int [][] matrix = new int [rows][rows];
    
    // Step-1: populate inputs
    for (int i=0; i < rows; i++) {
      for (int j=0; j < rows; j++) {
        matrix[i][j] = counter++;
        System.out.print (matrix[i][j] + "\t");
      }
      System.out.println ();
    }
    
    // Step-2: Print matrix in a spiral order
    List<Integer> output = new ArrayList<Integer>();
    for (int i=0 ; i <= rows/2; i++) {
      
      List<Integer> topRow = new ArrayList<Integer>();
      List<Integer> rightCol = new ArrayList<Integer>();
      List<Integer> bottomRow = new ArrayList<Integer>();
      List<Integer> leftCol = new ArrayList<Integer>();
      
      for (int j=i; j < rows-i; j++) {
        // top row
        topRow.add (matrix[i][j]);
        if (j!=i) {
          // right col
          rightCol.add (matrix[j][rows-1-i]);
          // bottom row
          bottomRow.add (matrix[rows-1-i][rows-1-j]);
        }
        if (j!=i && j!=(rows-1-i))
          // left col
          leftCol.add (matrix[rows-1-j][i]);
      }
      output.addAll(topRow);
      output.addAll(rightCol);
      output.addAll(bottomRow);
      output.addAll(leftCol);
    }
    System.out.println (output);
  }
}
