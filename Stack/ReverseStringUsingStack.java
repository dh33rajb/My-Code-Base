// Reverse a string using stack

import java.util.*;
import java.lang.*;

public class ReverseStringUsingStack {
    public static void main (String args[]) {
        String input = "dheeraj";
        String output = "";
        Stack <Character> stack = new Stack <Character> ();
        for (int i=0; i < input.length(); i++)
            stack.push (input.charAt(i));
        while (!stack.empty())
            output = output + stack.pop();
        System.out.println (output);
    }
}

