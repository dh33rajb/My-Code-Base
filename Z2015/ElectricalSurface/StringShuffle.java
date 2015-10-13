/*
Write a function that receives a sentence and returns it with each word modified so that the first and last letters are unchanged, but the rest is a random permutation.

Input:
This is a simple test message

Output:
Tihs is a siplme test mgsasee 
*/

import java.util.*;
import java.lang.*;

public class StringShuffle {
  public static void main (String args[]) {
    // Step-1: Read inputs
    String input = "This is a simple test message";
    
    // Step-2: Convert string to sub string arrays ==> O(N)
    String[] inputStringArr = input.split ("\\s+");
    StringBuilder output = new StringBuilder ("");
    
    // Step-3: Update the strings to modify words ==> O(N)
    for (String s : inputStringArr) {
      if (s.length() <= 2)
        output.append (s).append (" ");
      else {
        List<Character> list = new ArrayList <Character>();
        
        for (int i=1; i < s.length()-1; i++)
          list.add (s.charAt(i));
        
        Collections.shuffle(list);
        list.add (s.charAt(s.length()-1));
        
        output.append (s.charAt(0));
        for (char c : list)
          output.append (c);
        output.append (" ");
      }
    }
    System.out.println (input);
    System.out.println (output);
  }
}
