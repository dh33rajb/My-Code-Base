/*
Convert a string to number
*/

import java.util.*;
import java.lang.*;

public class StringToNumber {
  
  public static void main (String[] args) {
    String input = "-123456782";
    char[] charArr = input.toCharArray();
    
    int output = 0;
    for (char c : charArr)
      output = (output * 10) + (c - '0');
    
    if (input.charAt(0) == '-')
      output = output * -1;
    
    System.out.println (output);
  }
}
