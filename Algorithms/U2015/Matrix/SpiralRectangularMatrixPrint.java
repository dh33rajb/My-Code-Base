// SPIRAL RECTANGULAR MATRIX
/*
Input:
-----
0  1  2  3  
4  5  6  7  
8  9  10  11  
12  13  14  15  
16  17  18  19

Output:
------
[0, 1, 2, 3, 7, 11, 15, 19, 18, 17, 16, 12, 8, 4, 5, 6, 10, 14, 13, 9]
*/

import java.util.*;
import java.lang.*;

public class SpiralRectangularMatrixPrint {
  public static void main (String args[]) {
    int rows = 5; int cols = 4; int counter=0;
    int [][] matrix = new int [rows][cols];
    
    // Step-1: Populate inputs
    for (int i=0; i < rows; i++) {
      for (int j=0; j < cols; j++) {
        matrix[i][j] = counter++;
        System.out.print (matrix[i][j] + "\t");
      }
      System.out.println ();
    }
    
    // Step-2: Print matrix in a spiral order
    List<Integer> output = new ArrayList<Integer>();
    int currRow = 0;
    int currCol = 0;
    
    // Step-2.1: Base case
    if (rows==0 || cols==0) {
     System.out.println("Error with Input");
     return;
    }
    
    // Step-2.2: Linear case
    if (rows == 1 || cols == 1) {
      for (int i=0; i < rows; i++) {
        for (int j=0; j < cols; j++) {
          output.add (matrix[i][j]);
        }
      }
      System.out.println (output);
      return;
    }
    
    // Step-2.3: Generic case
    while (currRow <= rows/2 && currCol <= cols/2 && output.size() < (rows*cols)) {
      
      // top row
      for (int j=currCol; j < (cols-currCol); j++)
        output.add (matrix[currRow][j]);
      
      // right col
      for (int i=currRow+1; i < (rows-currRow); i++)
        output.add (matrix[i][(cols-1)-currCol]);
      
      // bottom row
      for (int j=currCol+1; j < (cols-currCol); j++)
        output.add (matrix[(rows-1)-currRow][(cols-1) - j]);
        
      // left col
      for (int i=currRow+1; i < (rows-currRow)-1; i++)
        output.add (matrix[(rows-1)-i][currCol]);
      
      currRow++;
      currCol++;
    }
    System.out.println (output);
  }
}
