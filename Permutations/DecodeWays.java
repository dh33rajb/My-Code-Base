// https://leetcode.com/problems/decode-ways/
/*
Input:
122112

Output:
1 2 2 1 1 2 
1 2 2 1 12 
1 2 2 11 2 
1 2 21 1 2 
1 2 21 12 
1 22 1 1 2 
1 22 1 12 
1 22 11 2 
12 2 1 1 2 
12 2 1 12 
12 2 11 2 
12 21 1 2 
12 21 12 
Total ways: 13
*/

import java.util.*;
import java.lang.*;

public class DecodeWays {
    private static int count;
    public static void main (String args[]) {
      // Step-1: Define inputs
      String s = "122112";
      count = 0;
      char[] charArray = s.toCharArray();
      findAllPermutations (charArray, 0 ,new ArrayList<String>());
      System.out.println ("Total ways: " + count);
    }
  
  public static void findAllPermutations (char[] charArray, int startIndex, List<String> outputList) {
    if (startIndex == charArray.length) {
      for (String s : outputList)
        System.out.print (s + " ");
      System.out.println();
      count++; 
    }
    String output = "";
    for (int i=startIndex; i < charArray.length; i++) {
        output = output + charArray[i];
      if (output.length() < 3 && Integer.valueOf(output) < 26) {
        outputList.add (output);
        findAllPermutations (charArray, startIndex+output.length(), outputList);
        if (outputList.size() > 0)
          outputList.remove(outputList.size()-1);
      }
    }
       
  }
}
