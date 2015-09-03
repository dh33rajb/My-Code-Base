// Reverse a stack java
/*
Input (Harcoded):  [1, 2, 3, 4, 5, 6, 7, 8, 9]
Output: [9, 8, 7, 6, 5, 4, 3, 2, 1]
*/

import java.util.*;
import java.lang.*;

public class ReverseStack {
    public static void main (String args[]) {
        List <Integer> input = Arrays.asList (new Integer [] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        Stack<Integer> stack = new Stack <Integer> ();
        for (int i : input)
            stack.add (i);
        System.out.println(stack);
        stack = reverseStack(stack);
        System.out.println(stack);
    }
    
    public static Stack<Integer> reverseStack (Stack<Integer> stack) {
        if (stack.empty())
            return stack;
        int poppedVal = stack.pop();
        // FIRST REVERSE THE STACK AND THEN INSERT TO BOTTOM
        stack = reverseStack (stack);
        stack = insertToBottom(stack, poppedVal);
        return stack;
    }
    
    public static Stack<Integer> insertToBottom (Stack<Integer> stack, int poppedVal) {
        if (stack.empty()) {
            stack.push (poppedVal);
            return stack;
        }
        int popVal = stack.pop();
        stack = insertToBottom (stack, poppedVal);
        stack.push (popVal);
        return stack;
    }
}
