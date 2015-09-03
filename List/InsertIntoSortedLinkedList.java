// Add element to Sorted linkedList

// Input: 1 2 3 5 6 7 8 9 10
// Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

import java.util.*;
import java.lang.*;

public class InsertIntoSortedLinkedList {
    public static void main (String args[]) {
        List <Integer> input = new LinkedList<Integer>();
        // Step-1: Reading inputs
        Scanner scanner = new Scanner (System.in);
        while (scanner.hasNextInt()) {
            input.add (scanner.nextInt());
        }
        // hardcoded value here for simplicity.. reading this via console is straight forward anyways..
        int value = 4;
        boolean flag = false;
        // Step-2: logic
        ListIterator<Integer> itr = input.listIterator();
        while (itr.hasNext()) {
            int next = itr.next();
            if (value <= next) {
                itr.set (value);
                itr.add (next);
                flag = true;
                break;
            }
        }
        if (!flag)
            input.add (value);
        System.out.println (input);
    }
}
