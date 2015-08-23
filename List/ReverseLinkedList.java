// Reverse a LinkedList

import java.util.*;
import java.lang.*;

public class ReverseLinkedList {
    public static void main (String args[]) {
        List <Integer> input = new ArrayList<Integer> ();
        // Step-1: Read Inputs
        Scanner scanner = new Scanner (System.in);
        while (scanner.hasNextInt()) {
            input.add (scanner.nextInt());
        }
        // Step-2: Core logic
        List <Integer> output = reverseList (input, 0);
        System.out.println (output);
    }
    
    public static List<Integer> reverseList (List<Integer> input, int index) {
        List <Integer> output = null;
        if (index == (input.size() - 1)) {
            output = new ArrayList<Integer> ();
            output.add (input.get(index));
            return output;
        }
        output = reverseList (input, (index+1));
        output.add (input.get(index));
        return output;
    }
}
