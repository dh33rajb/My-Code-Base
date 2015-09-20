/* Implement a Sudoko puzzle validator - given a 9x9 matrix of numbers (1-9) and "." for empty spaces, return true for a valid puzzle matrix and false if it would not be a valid sudoku puzzle. */

/*
Input:
------
    int matrix[][] = {{0, 0, 0, 2, 6, 0, 7, 0, 1},
                      {6, 8, 0, 0, 7, 0, 0, 9, 0},
                      {1, 9, 0, 0, 0, 4, 5, 0, 0},
                      {8, 2, 0, 1, 0, 0, 0, 4, 0},
                      {0, 0, 4, 6, 0, 2, 9, 0, 0},
                      {0, 5, 0, 0, 0, 3, 0, 2, 8},
                      {0, 0, 9, 3, 0, 0, 0, 7, 4},
                      {0, 4, 0, 0, 5, 0, 0, 3, 6},
                      {7, 0, 3, 0, 1, 8, 0, 0, 0}};
Output:
------
This is a perfectly fine Sudoku
*/
import java.util.*;
import java.lang.*;

public class IsSudokuGridValid {
  public static void main (String args[]) {
    // Step-1: Define a sudoku puzzle
    int matrix[][] = {{0, 0, 0, 2, 6, 0, 7, 0, 1},
                      {6, 8, 0, 0, 7, 0, 0, 9, 0},
                      {1, 9, 0, 0, 0, 4, 5, 0, 0},
                      {8, 2, 0, 1, 0, 0, 0, 4, 0},
                      {0, 0, 4, 6, 0, 2, 9, 0, 0},
                      {0, 5, 0, 0, 0, 3, 0, 2, 8},
                      {0, 0, 9, 3, 0, 0, 0, 7, 4},
                      {0, 4, 0, 0, 5, 0, 0, 3, 6},
                      {7, 0, 3, 0, 1, 8, 0, 0, 0}};
    
    // Step-2: Check if each row does not have a repeated number
    for (int i=0; i< matrix.length; i++) {
      Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
      for (int j=0; j<matrix[i].length; j++) {
        if (map.get(matrix[i][j]) == null) {
          if (matrix[i][j] != 0)
            map.put (matrix[i][j], true);
        }
        else {
          System.out.println ("Invalid Sudoku!");
          return;
        }
      }
    }
    
    // Step-3: Check if each column does not have a repeated number
      for (int i=0; i< matrix.length; i++) {
      Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
      for (int j=0; j<matrix[i].length; j++) {
        if (map.get(matrix[j][i]) == null) {
          if (matrix[j][i] != 0)
            map.put (matrix[j][i], true);
        }
        else {
          System.out.println ("Invalid Sudoku!");
          return;
        }
      }
    }
    
    // Step-4: Check 3*3 matrices
    int rowStart = 0; int colStart = 0;
    int rowEnd = 2; int colEnd = 2;
    while (rowEnd < 9 && colEnd < 9) {
      Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
      for (int i=rowStart; i <= rowEnd; i++ ) {
        for (int j=colStart; j <= colEnd; j++) {
          //System.out.print (matrix[i][j] + "\t");
          if (map.get(matrix[j][i]) == null) {
            if (matrix[j][i] != 0)
              map.put (matrix[j][i], true);
            }
            else {
              System.out.println ("Invalid Sudoku!");
              return;
            }
        }
        //System.out.println ();
      }
      //System.out.println ("--------------");
      if (rowEnd < 8) {
        rowStart = rowStart + 3;
        rowEnd = rowEnd + 3;
      }
      else {
        rowStart = 0;
        rowEnd = 2;
        colStart = colStart + 3;
        colEnd = colEnd+3;
      }
    }
    System.out.println ("This is a perfectly fine Sudoku");
  }
}
