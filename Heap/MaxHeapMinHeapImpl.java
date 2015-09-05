// INSERT COMPLETE | REMOVE YET TO BE DONE
/*
Input:
15 10 9 8 9 6 3 4 2 18

Output:
Max heap after insert: [18, 15, 9, 8, 10, 6, 3, 4, 2, 9]
Min heap after insert: [2, 3, 6, 4, 9, 10, 8, 15, 9, 18]
*/

// Max Heap and Min Heap implementation

import java.util.*;
import java.lang.*;

public class MaxHeapMinHeapImpl {
    public static void main (String args[]) {
        
        // Step-0: Initialization
        List<Integer> maxHeap = null;
        List<Integer> minHeap = null;
        
        // Step-1: Read inputs and MIN and MAX HEAP INSERT
        Scanner scanner = new Scanner (System.in);
        while (scanner.hasNextInt()) {
            int nextInt = scanner.nextInt();
            maxHeap = insertIntoMaxHeap (maxHeap, nextInt);
            minHeap = insertIntoMinHeap (minHeap, nextInt);
        }
        System.out.println ("Max heap after insert: " + maxHeap);
        System.out.println ("Min heap after insert: " + minHeap);
        
        // Step-2: MIN AND MAX HEAP REMOVE
        //removeFromMaxHeap();
        //removeFromMinHeap();
        
    }
    
    // INSERTION INTO MAX HEAP
    public static List<Integer> insertIntoMaxHeap (List<Integer> maxHeap, int value) {
        if (maxHeap == null) {
            maxHeap = new LinkedList<Integer> ();
            maxHeap.add (value);
            return maxHeap;
        }
        // add at the end
        maxHeap.add (value);
        
        // then move it to it's rightful place, if need be
        int currIndex = maxHeap.size()-1;
        int parentIndex =  (currIndex - 1) / 2;
            
        while (parentIndex >= 0) {
            // moving not necessary
            if (maxHeap.get (currIndex) <= maxHeap.get(parentIndex))
                return maxHeap;
            // moving needed
            int temp = maxHeap.get(parentIndex);
            maxHeap.set (parentIndex, maxHeap.get(currIndex));
            maxHeap.set (currIndex, temp);
            currIndex = parentIndex;
            parentIndex = (currIndex - 1) / 2;
        }
        return maxHeap;
    }
    
    // INSERTION INTO MIN HEAP
    public static List<Integer> insertIntoMinHeap (List<Integer> minHeap, int value) {
        if (minHeap == null) {
            minHeap = new LinkedList<Integer>();
            minHeap.add (value);
            return minHeap;
        }
        
        // add the incoming value to end of min heap
        minHeap.add (value);
        
        // now see if you need to move the integer to its rightful position
        int currIndex = minHeap.size()-1;
        int parentIndex = (currIndex - 1)/2;
        
        while (parentIndex >= 0) {
            if (minHeap.get(parentIndex) <= minHeap.get(currIndex))
                return minHeap;
            // else swapping needs to be done
            int temp = minHeap.get(parentIndex);
            minHeap.set (parentIndex, minHeap.get(currIndex));
            minHeap.set (currIndex, temp);
            currIndex = parentIndex;
            parentIndex = (currIndex - 1) / 2;
        }
        return minHeap;
    }
}






