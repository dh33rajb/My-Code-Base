// Print the middle eleemnt of a linkedlist

import java.util.*;
import java.lang.*;

public class LinkedListMiddle {
    public static void main (String args[]) {
        List<Integer> input = new ArrayList <Integer> ();
        // Step-1: Get inputs
        Scanner scanner = new Scanner (System.in);
        while (scanner.hasNextInt()) {
            input.add (scanner.nextInt());
        }
        int i=0;
        int j=0;
        while (j < input.size()) {
            i = i+1;
            j=j+2;
        }
        System.out.println (input.get(i-1));
    }
}
