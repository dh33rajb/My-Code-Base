// Find if two strings are ANAGRAMS of each other

/*
Input:
------
String stringOne = "cinema";
String stringTwo = "iceman";

Output:
------
Anagram
*/

import java.util.*;
import java.lang.*;

public class AnagramTwoStrings  {
  public static void main (String args[]) {
    // Step-1: Inputs
    String stringOne = "abcde";
    String stringTwo = "ecadb";
    
    // Step-2: Core logic
    boolean result = areTwoStringsAnagrams (stringOne, stringTwo);
    if (result)
      System.out.println ("ANAGRAM");
    else
      System.out.println ("NOT AN ANAGRAM");
  }
  
  public static boolean areTwoStringsAnagrams (String stringOne, String stringTwo) {
    int[] countArr = new int[26];
    for (int i=0; i < 26; i++)
      countArr[i] = 0;
    
    // Step-1: String pre-processing (clean-up): remove special characters and spaces from string
    stringOne = stringOne.toLowerCase().replaceAll("[^a-z]+", "");
    stringTwo = stringTwo.toLowerCase().replaceAll("[^a-z]+", "");
    
    // Step-2: Add count to countArr from stringOne
    for (int i=0; i < stringOne.length(); i++) {
      int index = stringOne.charAt(i) - 'a';
      countArr [index] = countArr[index] + 1;
    }
    
    // Step-3: subtract count from countArr from stringTwo
    for (int i=0; i < stringTwo.length(); i++) {
      int index = stringTwo.charAt(i) - 'a';
      countArr [index] = countArr[index] - 1;
    }
    
    // Step-4: Check if count array has all values == 0
    for (int i : countArr) {
      if (i != 0) {
        return false;
      }
    }
    return true;
  }
}
