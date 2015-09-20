// Given a list of words, find whether a new word is anagram of word in list
// Print the word in the list that the input string is an anagram of

/*
Input:
------
String input = "cinema";
String inputArr[] = {"icema", "man ice", "mancei",  "iceman", "manicee", "mance"};

Output:
------
cinema and icema are NOT ANAGRAMS!
cinema and man ice are ANAGRAMS!
cinema and mancei are ANAGRAMS!
cinema and iceman are ANAGRAMS!
cinema and manicee are NOT ANAGRAMS!
cinema and mance are NOT ANAGRAMS!
*/

import java.util.*;
import java.lang.*;

public class AnagramsStringAndList  {
  public static void main (String args[]) {
    // Step-1: Inputs
    String input = "cinema";
    String inputArr[] = {"icema", "man ice", "mancei",  "iceman", "manicee", "mance"};
    
    // Step-2: Core logic
    for (String s : inputArr) {
        boolean result = areTwoStringsAnagrams (input, s);
        if (result)
          System.out.println (input + " and " + s + " are ANAGRAMS!");
        else
          System.out.println (input + " and " + s + " are NOT ANAGRAMS!");
    }
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
