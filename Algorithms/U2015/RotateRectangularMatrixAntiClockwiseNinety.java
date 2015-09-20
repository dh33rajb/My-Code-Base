// ROTATE RECTANGULAR MATRIX ANTI-CLOCKWISE BY NINETY
// SOLUTION: TRANSPOSE AND INTERCHNAGE ROWS
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
6 13 20 27 34 
5 12 19 26 33 
4 11 18 25 32 
3 10 17 24 31 
2 9 16 23 30 
1 8 15 22 29 
0 7 14 21 28 
*/

import java.util.ArrayList;
import java.util.List;

// RotateRectangularMatrixAntiClockwiseNinety
public class RotateRectangularMatrixAntiClockwiseNinety {
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

    // Step-2: Rotate matrix by one ANTI-CLOCKWISE
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
    
    // Step-2.3: Interchange ROWS to rotate anti-clockwise (left)
    int transposeRows = cols;
    int transposeCols = rows;
    for (int i=0; i <= transposeRows/2; i++) { // rows is transpose matrix's column
      for (int j=0; j < transposeCols; j++) { // cols is transpose matrix's row
        int temp = transposeMatrix[i][j];
        transposeMatrix[i][j] = transposeMatrix[transposeRows-1-i][j];
        transposeMatrix[transposeRows-1-i][j] = temp;
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
