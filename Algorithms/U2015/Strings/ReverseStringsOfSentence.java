// REVERSE each individual words in a string
/*
Input:
------
"Hello to this world"

Output:
-------
"olleH ot siht dlrow"

*/
import java.io.*;
import java.util.*;

public class ReverseStringsOfSentence {
  public static void main(String[] args) {
    
    // Step-1: Inputs and Initialization
    String input = "Hello to this world";
    
    // Step-2: Core Logic
    String output = reverseWordsInSentence (input);
    
    // Step-3: Print result
    System.out.println (output);
  }
  // Function to reverse every word in a sentence
  public static String reverseWordsInSentence(String input) {
    // Base cases
    if (input == null)
      return "Error in Input";
    else if (input.length() < 2)
      return input;
    
    // Generic case
    StringBuilder output = new StringBuilder("");
    String [] wordArr = input.split ("\\s");
    for (String word : wordArr)
      output.append(" ").append(reverseWord(word.toCharArray()));
    
    return output.toString().trim();
  }
  // Function to reverse a word IN-PLACE
  public static String reverseWord (char[] wordArr) {
    int length = wordArr.length;
    for (int i=0; i < length/2; i++) {
      char temp = wordArr[i];
      wordArr[i] = wordArr [length-1-i];
      wordArr[length-1-i] = temp;
    }
    return String.valueOf (wordArr);
  }
}
