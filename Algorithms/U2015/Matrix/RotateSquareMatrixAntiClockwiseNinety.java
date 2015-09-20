// ROTATE SQUARE MATRIX ANTI-CLOCKWISE BY NINETY

/*
Input:
------
0	1	2	3	4	
5	6	7	8	9	
10	11	12	13	14	
15	16	17	18	19	
20	21	22	23	24	

Output:
------
4 9 14 19 24 
3 8 13 18 23 
2 7 12 17 22 
1 6 11 16 21 
0 5 10 15 20 
*/

import java.util.ArrayList;
import java.util.List;

public class RotateSquareMatrixAntiClockwiseNinety {
  public static void main(String args[]) {
    // Step-1: Reading inputs
    int rows = 5; int counter=0;
    int [][] matrix = new int [rows][rows];
    
    // Step-1: Populate inputs
    for (int i=0; i < rows; i++) {
      for (int j=0; j < rows; j++) {
        matrix[i][j] = counter++;
        System.out.print (matrix[i][j] + "\t");
      }
      System.out.println ();
    }

    // Step-2: Rotate matrix by one ANTI-CLOCKWISE
    for (int i = 0; i < rows / 2; i++) {
      for (int j = i; j < rows - i - 1; j++) {
        int saved = matrix[i][j];
        matrix[i][j] = matrix[j][rows-1-i];
        matrix[j][rows-1-i] = matrix[rows - 1 - i][rows - 1 - j];
        matrix[rows - 1 - i][rows - 1 - j] = matrix[rows-1-j][i];
        matrix[rows-1-j][i] = saved;
      }
    }
    // Step-3: Print output
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < rows; j++) {
        System.out.print(matrix[i][j]+ " ");
      }
      System.out.println();
    }
  }
}
