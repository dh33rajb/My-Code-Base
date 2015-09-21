// All permutations of a string, WITHOUT REPETETION
/*
Input:
------
String str = "abcc";

Output:
-------
abcc
acbc
accb
bacc
bcac
bcca
cabc
cacb
cbac
cbca
ccab
ccba
*/

import java.lang.*;
import java.util.*;

public class AllPermutationWithoutRepetetion {

  public static void main(String args[]) {
    String str = "abcc";
    char[] charArr = str.toCharArray();
    boolean[] boolArr = new boolean[charArr.length];

    StringBuilder output = new StringBuilder ();
    doPermute(charArr, boolArr, output, 0, new HashMap<String, Boolean>());
  }

  public static void doPermute(char[] charArr, boolean[] boolArr,
      StringBuilder output, int level, Map<String, Boolean> dictionary) {
    if (level == charArr.length) {
      if (dictionary.get(output.toString()) == null) {
        dictionary.put(output.toString(), true);
        System.out.println(output.toString());
      }
      return;
    }
    for (int i = 0; i < charArr.length; ++i) {
      if (boolArr[i])
        continue;
      output.append(charArr[i]);
      boolArr[i] = true;
      doPermute(charArr, boolArr, output, level + 1, dictionary);
      boolArr[i] = false;
      output.setLength(output.length() - 1);
    }
  }
}
