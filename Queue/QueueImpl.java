// Implement Queue using Linked List
/*
Input: 10 9 8 7 6 5 4 3 2 1
Output:
[10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
[9, 8, 7, 6, 5, 4, 3, 2, 1]
[8, 7, 6, 5, 4, 3, 2, 1]
[7, 6, 5, 4, 3, 2, 1]
*/
import java.util.*;
import java.lang.*;

public class QueueImpl {
    public static void main (String args[]) {
        List<Integer> queue = null;
        // Step-1: Read inputs
        Scanner scanner = new Scanner (System.in);
        while (scanner.hasNextInt()) {
            int input = scanner.nextInt();
            queue = enQueue(queue, input);
        }
        System.out.println (queue);
        for (int i=0; i<3; i++) {
            queue = deQueue(queue);
            System.out.println (queue);
        }
    }
    
    public static List<Integer> enQueue (List<Integer> queue, int value) {
        if (queue == null)
            queue = new LinkedList<Integer>();
        queue.add (value);
        return queue;
    }
    
    public static List<Integer> deQueue (List<Integer> queue) {
        /* queue.remove(0);
           return queue;*/
        List<Integer> newList = new LinkedList<Integer>();
        for (int i=1; i< queue.size(); i++)
            newList.add(queue.get(i));
        return newList;
    }
}
