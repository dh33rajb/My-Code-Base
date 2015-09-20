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

public class AnagramTwoStrings {
  public static void main (String args[]) {
    // Step-1: Inputs
    String stringOne = "cinema";
    String stringTwo = "iceman";
    
    int[] countArr = new int[26];
    for (int i=0; i < 26; i++)
      countArr[i] = 0;
    
    // Step-2: String pre-processing (clean-up): remove special characters and spaces from string
    stringOne = stringOne.toLowerCase().replaceAll("[^a-z]+", "");
    stringTwo = stringTwo.toLowerCase().replaceAll("[^a-z]+", "");
    
    // Step-3: Add count to countArr from stringOne
    for (int i=0; i < stringOne.length(); i++) {
      int index = stringOne.charAt(i) - 'a';
      countArr [index] = countArr[index] + 1;
    }
    
    // Step-4: subtract count from countArr from stringTwo
    for (int i=0; i < stringTwo.length(); i++) {
      int index = stringTwo.charAt(i) - 'a';
      countArr [index] = countArr[index] - 1;
    }
    
    // Step-5: Check if count array has all values == 0
    for (int i : countArr) {
      if (i != 0) {
        System.out.println ("Not an Anagram");
        return;
      }
    }
    System.out.println ("Anagram");
  }
}
