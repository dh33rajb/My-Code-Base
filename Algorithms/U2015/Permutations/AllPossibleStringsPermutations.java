import java.util.*;
import java.lang.*;
/*
Input:
-----
abc

Output:
------
a
ab
abc
ac
acb
b
ba
bac
bc
bca
c
ca
cab
cb
cba
*/
public class AllPossibleStringsPermutations {
  public static void main (String args[]) {
    String input = "abc";
    printAllSubsetsOfString (input.toCharArray(), new boolean[input.length()], 0, new StringBuilder(""));
  }
  
  public static void printAllSubsetsOfString (char[] inputArr, boolean[] boolArr, int level, StringBuilder output) {
    //if (level == inputArr.length)
      //System.out.println (output.toString());
    
    for (int i=level; i < inputArr.length; i++) {
      //System.out.println (boolArr[i]);
      if (boolArr[i])
        continue;
      boolArr[i] = true;
      output.append (inputArr[i]);
      System.out.println (output);
      printAllSubsetsOfString (inputArr, boolArr, level, output);
      boolArr[i] = false;
      output.setLength (output.length()-1);
    }
  }
}
