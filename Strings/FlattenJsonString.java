/*
Create a Json like object to representation and implement a flatten method to return string -> string mapping. 
(implement from scratch / test / compiling + working code) 

{x:1, y:1, z:{a:1,b:2}} flattens to {x:1, y:1, z.a:1, z.b: 2}
{x:1, y:1, z:{a:{b:2}} flattens to {x:1, y:1, z.a.b:2}
{x:1, y:1, z:{a:{b:2}, c:3} flattens to {x:1, y:1, z.a.b:2, z.c:3}

*/

import java.io.*;
import java.util.*;

public class FlattenJsonString {
  
  public static void main(String[] args) {
    String input = "{x:1, y:1, z:{a:{b:2}, c:3}";
    String output = "";
    Stack<String> stack = new Stack<String>();
    System.out.println (input);
    output = flattenJson(input, stack);
    System.out.println (output);
    }
  
  public static String flattenJson (String input, Stack<String> stack) {
    String output = "";
    boolean flag = false;
    List<Character> parentNestList = new ArrayList<Character>();
    
    for (int i=0; i < input.length(); i++) {
          char currChar = input.charAt(i);
          switch (currChar) {
            case '{':
              if (i != 0)
                flag = true;
              break;

            case '}':
              if (i != (input.length()-1) && parentNestList.size()>0)
                parentNestList.remove(parentNestList.size()-1);
              break;
            
            case ':':
              break;
            case ',':
              break;
            case ' ':
              break;

            default:
              if (flag) {
                parentNestList.add (stack.pop().charAt(0));
                flag=false;
                stack.push (String.valueOf(currChar));
              } else if (!flag && parentNestList.size()>0 && ((currChar-'a') >=26 || (currChar-'a') < 0)) {
                String temp="";
                for (int j=0; j < parentNestList.size(); j++){
                  temp = temp+ parentNestList.get(j);
                  temp = temp + ".";
                }
                stack.push (temp + stack.pop());
                stack.push (String.valueOf(currChar));
              } else {
                stack.push (String.valueOf(currChar));
              }
          }
        System.out.println(stack);
    }
    boolean flag2=true;
    for (int i=0; i < stack.size(); i++) {
    }
    return output;
  }
}
