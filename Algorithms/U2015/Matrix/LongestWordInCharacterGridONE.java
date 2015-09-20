// Find the longest word in a grid of random letter, each consecutive letters has to be next to the previous one.
// IF THE CONSECUTIVE STRINGS "CANNOT" and "CAN" SPAN OVER NEXT ROWS.. BOTH CASES HANDLED HERE
/*
IF CONSECUTIVE STRINGS "CANNOT" SPAN ACROSS ROWS
Input:
------
char grid[][]= {{'q', 'w', 'e', 'r', 't', 'y'},
                {'a', 's', 'd', 'f', 'g', 'h'},
                {'z', 'x', 'c', 'v', 'b', 'n'},
                {'a', 'b', 'c', 'd', 'e', 'f'},
                {'l', 'm', 'n', 'o', 'p', 'q'}};
                
Output:
-------
Longest consecutive letter string: abcdef

IF CONSECUTIVE STRINGS "CAN" SPAN ACROSS ROWS
char grid[][]= {{'q', 'w', 'e', 'r', 't', 'y'},
                {'a', 's', 'd', 'f', 'g', 'h'},
                {'z', 'x', 'c', 'v', 'b', 'n'},
                {'a', 'b', 'c', 'd', 'e', 'f'},
                {'l', 'm', 'n', 'o', 'p', 'q'},
                {'r', 'm', 'n', 'o', 'p', 'q'}};

output:
-------
Longest consecutive letter string: lmnopqr
*/
import java.lang.*;
import java.util.*;

public class LongestWordInCharacterGridONE {
  public static void main (String args[]) {
    
    // Step-1: Define inputs
    char grid[][]= {{'q', 'w', 'e', 'r', 't', 'y'},
                    {'a', 's', 'd', 'f', 'g', 'h'},
                    {'z', 'x', 'c', 'v', 'b', 'n'},
                    {'a', 'b', 'c', 'd', 'e', 'f'},
                    {'l', 'm', 'n', 'o', 'p', 'q'},
                    {'r', 'f', 'j', 'k', 't', 'y'}};
    
    // Step-2: Core logic
    /* working code here is for CANNOT span across rows case
       for CAN span across rows case, pull the below code snippet and put it ouside the outer for loop.. all will work weell then
       
      char prevChar = ' ';
      String localMaxString = "";
    */
    String maxString = "";
    for (int i=0; i < grid.length; i++) {
      char prevChar = ' ';
      String localMaxString = "";
      for (int j=0; j < grid[i].length; j++) {
        int charGap = grid[i][j] - prevChar;
        if (charGap == 1) {
          localMaxString = localMaxString + grid[i][j];
          if (localMaxString.length() > maxString.length())
            maxString = localMaxString;
        } else {
          localMaxString = "" + grid[i][j];
        }
        prevChar = grid[i][j];
      }
    }
    System.out.println ("Longest consecutive letter string: " + maxString);
  }
}
