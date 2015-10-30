// String anagram

import java.util.*;
import java.lang.*;

public class StringAnagram {
  public static void main (String args[]) {
    System.out.println (isAnagram ("12345abcde", "abcde15243"));
  }


  public static boolean isAnagram (String s1, String s2) {
    // base cases
    if (s1 == null && s2 == null)
      return true;
    if (s1 == null || s2 == null)
      return false;
    if (s1.length() != s2.length())
      return false;

    // generic cases
    Map<Character, Integer> map = new HashMap <Character, Integer> ();

    char[] chars1 = s1.toCharArray();
    char[] chars2 = s2.toCharArray();

    // put all characters of first string to map.. add count against each entry
    for (char c : chars1) {
      if (map.get(c) == null) {
        map.put (c, 1);
      } else {
        map.put (c, map.get(c) + 1);
      }
    }

    // put all characters of second string to map.. subtract count against each entry
    for (char c : chars2) {
      if (map.get(c) == null) {
        return false;
      } else {
        map.put (c, map.get(c) - 1);
      }
    }

    // check map for any value that is not 0
    for (Map.Entry<Character, Integer> e : map.entrySet()) {
      if (e.getValue() != 0)
        return false;
    }

    return true;
  }
}
