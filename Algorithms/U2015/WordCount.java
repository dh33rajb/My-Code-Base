// Input a string and output the number of words
/*
Input:
-----
!!!! 2 a!ddcd ddvcewf43r=4r4r tg g t 5t45t.gntyh6 y

Output:
-------
11
*/
import java.util.*;
import java.lang.*;

public class WordCount {
  public static void main (String args[]) {
    // Step-1: Get inputs
    String input = "!!!! 2 a!ddcd ddvcewf43r=4r4r tg g t 5t45t.gntyh6 y";
    int numOfWords = 0;
    
    // Step-2: Core logic
    String[] wordArr = input.split ("[\\W\\s]+");
    int counter = 0;
    for (String s : wordArr) {
      if (!s.equals("") && !s.equals (" ")) {
        System.out.println ("word: " + s);
        counter++;
      }
    }
    System.out.println (counter);
  }
}
