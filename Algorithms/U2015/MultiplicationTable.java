// print multiplication table from 1 x1 to 12 x12  

import java.util.*;
import java.lang.*;

public class MultiplicationTable {
  public static void main (String args[]) {
    int n = 12;
    
    for (int i=1; i <= n; i++) {
      for (int j=1; j <= n; j++) {
        System.out.println (i + " * " + j + " = " + i*j);
      }
    }
  }
}
