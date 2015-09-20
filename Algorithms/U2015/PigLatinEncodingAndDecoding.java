/*
PIG LATIN ENCODING
-------------------
Write a program in java to accept a word through user input and encode it to piglatin.

To translate word into Piglatin word, 
  1. convert the word into uppercase, and then 
  2. place the first vowel of the original word as the start of the new word along with the remaining alphabets. 
  3. The alphabets present before the vowel being shifted towards the end followed by “AY” if a word begins with consonant or with "YAY" if it begins with a vowel.
  
  London   ONDONLAY
  Olympics   OLYMPICSAY
*/
import java.util.*;
import java.lang.*;

public class PigLatinEncodingAndDecoding {
  public static void main (String args[]) {
    String input = "yabcde";
    
    String pigLatinEncodedText = doPigLatinEncoding (input);
    System.out.println (pigLatinEncodedText);
    
    String pigLatinDecodedText = doPigLatinDecoding (pigLatinEncodedText);
    System.out.println (pigLatinDecodedText);
  }
  
  public static String doPigLatinEncoding (String input) {
    StringBuilder preVowelOutput = new StringBuilder ("");
    StringBuilder postVowelOutput = new StringBuilder ("");
    
    // Step-1: Convert input string to upper case
    input = input.toUpperCase();
    
    // Step-2: Compute pre-vowel substring and post-vowel substring
    boolean flag = false; // we haven't seen first vowel yet
    for (int i=0 ; i < input.length(); i++) {
      if (!flag && (input.charAt(i) == 'A' || input.charAt(i) == 'E' || input.charAt(i) == 'I' || 
          input.charAt(i) == 'O' || input.charAt(i) == 'U')) {
          flag = true;
      }
      if (flag)
        postVowelOutput.append(input.charAt(i));
      else
        preVowelOutput.append(input.charAt(i));
    }
    /* Step-3: if (preVowelOutput == empty) ==> postVowelOutput +  YAY
               if (preVowelOutput != empty) ==> postVowelOutput + preVowelOutput + AY */
    String output = "";
    if (preVowelOutput.toString().equals(""))
      output = postVowelOutput.append("YAY").toString();
    else
      output = postVowelOutput.append(preVowelOutput).append("AY").toString();
      
    return output;
  }
  
  public static String doPigLatinDecoding (String pigLatinEncodedText) {
    if (pigLatinEncodedText == null || pigLatinEncodedText.size() < 0)
      return "";
    return "";
  }
}
