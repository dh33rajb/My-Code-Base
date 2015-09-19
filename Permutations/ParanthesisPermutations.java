// Print all permutations of 3 pair of parens. ()()(), (()()), (())(),,,. etc 

import java.util.*;
import java.lang.*;

// ParanthesisPermutations
public class ParanthesisPermutations {
  public static void main (String args[]) {
    int n =4;
    printAllPermutationsOfParens(n, 0, 0, "");
  }
  
  public static void printAllPermutationsOfParens (int n, int openUsed, int closeUsed, String output) {
    // Base condition
    if (n < 0)
      return;
    
    // Core logic
    if (openUsed == closeUsed && closeUsed == n) {
      System.out.println (output);
      return;
    }
   
    if (openUsed > closeUsed ) {
      output = output + ")";
      printAllPermutationsOfParens (n, openUsed, ++closeUsed, output);
      output = output.substring (0, output.length()-1);
      closeUsed--;
    }
    
    if (openUsed < n) {
      output = output + "(";
      printAllPermutationsOfParens (n, ++openUsed, closeUsed, output);
      output = output.substring (0, output.length()-1);
      openUsed--;
    }
  }
}
