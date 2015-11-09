
import java.util.*;
import java.lang.*;

// s1 = "abcaaadefgh" s2 = "defg"
class StrStr {
  public static void main (String args[]) {
    System.out.println (strStr ("abcdef", "abc"));
  }
  
  public static int strStr (String s1, String s2) {
    // base case
    if (s1 == null || s2 == null || s1.equals ("") 
        || s2.equals ("") || s1.length() < s2.length())
      return -1;
    
    // generic case
    int i = 0;
    int j = 0;
    int start = -1;
    while (j < s2.length() && i < s1.length()) {
      if (s1.charAt (i) == s2.charAt(j)) {
        if (start == -1)
          start = i;
        i++;
        j++;
      } else {
        start = -1;
        j = 0;
        i++;
      } 
    }
    if (j != s2.length())
      start = -1;
    return start;
  }
}
