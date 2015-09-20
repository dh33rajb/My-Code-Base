// ROTATE SQUARE MATRIX CLOCKWISE BY NINETY
/*
Input:
------
0	1	2	3	4	
5	6	7	8	9	
10	11	12	13	14	
15	16	17	18	19	
20	21	22	23	24	

Output:
-------
20 15 10 5 0 
21 16 11 6 1 
22 17 12 7 2 
23 18 13 8 3 
24 19 14 9 4 
*/
import java.util.ArrayList;
import java.util.List;

public class RotateSquareMatrixClockwiseNinety {
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

    // Step-2: Rotate matrix by one CLOCKWISE
    for (int i = 0; i < rows / 2; i++) {
      for (int j = i; j < rows - i - 1; j++) {
        int saved = matrix[i][j];
        matrix[i][j] = matrix[rows - j - 1][i];
        matrix[rows - j - 1][i] = matrix[rows - 1 - i][rows - 1 - j];
        matrix[rows - 1 - i][rows - 1 - j] = matrix[j][rows - 1 - i];
        matrix[j][rows - 1 - i] = saved;
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
