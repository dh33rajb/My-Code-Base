//Unique Paths: https://leetcode.com/problems/unique-paths/

public class UniquePathsOne {
    public static void main (String args[]) {
      int m = 2;
      int n = 2;
      int[][] matrix = new int [m][n];
      matrix[0][0] = 1;
      for (int i=0; i < m; i++) {
        for (int j=0; j < n; j++) {
          if (i==0 && j==0)
            continue;
          else if (i == 0 && j !=0)
              matrix[i][j] = matrix[i][j-1];
          else if (j == 0 && i != 0)
              matrix[i][j] = matrix[i-1][j];
          else
              matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
        }
      }
      System.out.println (matrix[m-1][n-1]);
    }
}
