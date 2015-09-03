// Design stack using list and implement minStack function that gives minimum elemnt in a stack anytime
/*
Input: 10 9 8 7 6 5 4 3 2 1
Output:
Success

Output:
Stack: [10]
Min stack: [10]
Stack: [10, 9]
Min stack: [10, 9]
Stack: [10, 9, 8]
Min stack: [10, 9, 8]
Stack: [10, 9, 8, 7]
Min stack: [10, 9, 8, 7]
Stack: [10, 9, 8, 7, 6]
Min stack: [10, 9, 8, 7, 6]
Stack: [10, 9, 8, 7, 6, 5]
Min stack: [10, 9, 8, 7, 6, 5]
Stack: [10, 9, 8, 7, 6, 5, 4]
Min stack: [10, 9, 8, 7, 6, 5, 4]
Stack: [10, 9, 8, 7, 6, 5, 4, 3]
Min stack: [10, 9, 8, 7, 6, 5, 4, 3]
Stack: [10, 9, 8, 7, 6, 5, 4, 3, 2]
Min stack: [10, 9, 8, 7, 6, 5, 4, 3, 2]
Stack: [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
Min stack: [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
Stack: [10, 9, 8, 7, 6, 5, 4, 3, 2]
Min stack: [10, 9, 8, 7, 6, 5, 4, 3, 2]
Stack: [10, 9, 8, 7, 6, 5, 4, 3]
Min stack: [10, 9, 8, 7, 6, 5, 4, 3]
Stack: [10, 9, 8, 7, 6, 5, 4]
Min stack: [10, 9, 8, 7, 6, 5, 4]
*/
import java.util.*;
import java.lang.*;

public class StackAndMinStackImpl {
    private static Stack<Integer> minStack;
    public static void main (String args[]) {
        List <Integer> stack = new ArrayList <Integer> ();
        minStack = new Stack<Integer> ();
        // Step-1: Read inputs
        Scanner scanner = new Scanner (System.in);
        while (scanner.hasNextInt()) {
            int input = scanner.nextInt();
            stack = insertToStack (stack, input);
            System.out.println ("Stack: " + stack);
            System.out.println ("Min stack: " + minStack);
        }
        for (int i=0; i< 3; i++) {
            stack = popStack (stack);
            System.out.println ("Stack: " + stack);
            System.out.println ("Min stack: " + minStack);
        }
    }
    
    public static List<Integer> insertToStack (List<Integer> stack, int value) {
        stack.add (value);
        if (!minStack.empty()) {
            int currMinVal = minStack.peek();
            if (value < currMinVal)
                minStack.push (value);
        } else
            minStack.push (value);
        return stack;
    }
    public static List<Integer> popStack (List<Integer> stack) {
        if (minStack.peek() == stack.get (stack.size()-1))
            minStack.pop();
        stack.remove (stack.size()-1);
        return stack;
    }
}
