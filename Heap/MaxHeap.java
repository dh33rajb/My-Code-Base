//Given a List, arrange it to a Max Heap

/* Input: 97 93 84 90 79 83 83 42 55 73 21 80
Output:
MAX HEAP
*/

import java.util.*;
import java.lang.*;

public class MaxHeap {
    public static void main (String args[]) {
        List<Integer> input = new ArrayList<Integer>();
        // Step-1: read inputs
        Scanner scanner = new Scanner (System.in);
        while (scanner.hasNextInt()) {
            input.add (scanner.nextInt());
        }
        
        // Step-2: Check if the input is a max heap
        boolean flag = true;
        for (int i=0; i < input.size(); i++) {
            int left = (2*i) + 1; 
            int right = (2*i) + 2;
            if ((left < input.size() && input.get (i) < input.get (left)) || right < input.size() && input.get(i) < input.get (right)) {
                flag = false;
                break;
            }
        }
        if (flag)
            System.out.println ("MAX HEAP");
        else {
            System.out.println ("NOT MAX HEAP");
        }
    }
}
