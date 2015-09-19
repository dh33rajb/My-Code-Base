// write code to print the matrix from outside to inside. (spiral print matrix)
/*
Input:
-----
0	1	2	3	4	
5	6	7	8	9	
10	11	12	13	14	
15	16	17	18	19	
20	21	22	23	24	

Output:
------
[0, 1, 2, 3, 4, 9, 14, 19, 24, 23, 22, 21, 20, 15, 10, 5, 6, 7, 8, 13, 18, 17, 16, 11, 12]
*/

import java.util.*;
import java.lang.*;

public class SpiralSquareMatrixPrint {
  public static void main (String args[]) {
    int rows = 5; int cols = 5; int counter = 0;
    int [][] matrix = new int [rows][cols];
    
    // Step-1: populate inputs
    for (int i=0; i < rows; i++) {
      for (int j=0; j < cols; j++) {
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
      
      for (int j=i; j < cols-i; j++) {
        // top row
        topRow.add (matrix[i][j]);
        // right col
        rightCol.add (matrix[j][cols-1-i]);
        // bottom row
        bottomRow.add (matrix[rows-1-i][cols-1-j]);
        // left col
        leftCol.add (matrix[rows-1-j][i]);
      }
      for (int a=0; a < topRow.size();a++)
        output.add (topRow.get(a));
      for (int b=1; b < rightCol.size();b++)
        output.add (rightCol.get(b));
      for (int c=1; c < bottomRow.size();c++)
        output.add (bottomRow.get(c));
      for (int d=1; d < leftCol.size()-1;d++)
        output.add (leftCol.get(d));
    }
    System.out.println (output);
  }
}
