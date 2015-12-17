import java.io.*;
import java.util.*;
/*
  dic1
    dic2
    dic3
      pic.png
      note1.txt
      dic4
        dic6
          pic2.png
  dic5

*/
class Solution {
  
  public static void main(String[] args) {
    String input = "\tdic1\n\t\tdic2\n\t\t\tdic3\n\t\t\t\tpic.png";
    int output = findLongestLengthOfImage (input);
    System.out.println (output);
  }
  
  public static int findLongestLengthOfImage (String input) {
    // base case
    if (input == null || input.length() == 0 )
      return 0;
    
    // generic case
    String[] inputStr= input.split ("\n");
    String maxImageStr = "";
    int maxImageCount = 0;
    int imageIndex = 0;

    // find the deepest image string name
    int c = 0;
    for (String str : inputStr) {
      if (str.contains ("jpg") || str.contains("png") || str.contains ("jpeg")) {
        int currImageCount =  findMatches (str);
        // System.out.println (str);
        if (currImageCount > maxImageCount) {
          maxImageCount = currImageCount;
          maxImageStr = str;
          imageIndex = c;
        }
      }
      c++;
    }
    // System.out.println (maxImageStr);
    // now find the heirarchy of the string reverse up from the image location
    String output = "";
    for (int i=imageIndex; i >= 0; i--) {
      String str = inputStr[i];
      int cnt  = findMatches (str);
      if (cnt == maxImageCount) {
        output = "/" + str.replaceAll("\n", "").replaceAll("\t", "") + output;
        maxImageCount--;
      }
    }
    System.out.println (output);
    return output.length();
  }
  
  // regex for pattern matching to count # of tabs
  public static int findMatches (String str) {
    java.util.regex.Pattern p = java.util.regex.Pattern.compile("\t");
    java.util.regex.Matcher m = p.matcher(str);
    int count = 0;
    while (m.find()){
      count +=1;
    }
    return count;
  }
}
