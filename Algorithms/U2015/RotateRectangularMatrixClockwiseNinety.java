// ROTATE RECTANGULAR MATRIX CLOCKWISE BY NINETY
// SOLUTION: TRANSPOSE AND INTERCHNAGE COLUMNS
/*
Input:
-----
0  1  2  3  4  5  6  
7  8  9  10  11  12  13  
14  15  16  17  18  19  20  
21  22  23  24  25  26  27  
28  29  30  31  32  33  34  

Output:
-------
28 21 14 7 0 
29 22 15 8 1 
30 23 16 9 2 
31 24 17 10 3 
32 25 18 11 4 
33 26 19 12 5 
34 27 20 13 6
*/

import java.util.ArrayList;
import java.util.List;

// RotateRectangularMatrixClockwiseNinety
public class RotateRectangularMatrixClockwiseNinety {
  public static void main(String args[]) {
    int rows = 5; int cols = 7; int counter=0;
    int [][] matrix = new int [rows][cols];
    
    // Step-1: Populate inputs
    for (int i=0; i < rows; i++) {
      for (int j=0; j < cols; j++) {
        matrix[i][j] = counter++;
        System.out.print (matrix[i][j] + "\t");
      }
      System.out.println ();
    }

    // Step-2: Rotate matrix by one CLOCKWISE
    int [][] transposeMatrix = new int [cols][rows];
    
    // Step-2.1: Base case
    if (rows == 0 || cols == 0) {
      System.out.println ("Error in input");
      return;
    }
    
    // Step-2.2: Take transpose of the matrix
    for (int i=0; i < rows; i++) {
      for (int j=0; j< cols; j++) {
        transposeMatrix[j][i] = matrix[i][j];
      }
    }
    
    // Step-2.3: Interchange COLUMNS to rotate clockwise (right)
    int transposeRows = cols;
    int transposeCols = rows;
    for (int i=0; i <= transposeCols/2; i++) { // rows is transpose matrix's column
      for (int j=0; j < transposeRows; j++) { // cols is transpose matrix's row
        int temp = transposeMatrix[j][i];
        transposeMatrix[j][i] = transposeMatrix[j][transposeCols-1-i];
        transposeMatrix[j][transposeCols-1-i] = temp;
      }
    }
    
    // Step-3: Print output
    for (int i = 0; i < transposeRows; i++) {
      for (int j = 0; j < transposeCols; j++) {
        System.out.print(transposeMatrix[i][j]+ " ");
      }
      System.out.println();
    }  
  }
}
