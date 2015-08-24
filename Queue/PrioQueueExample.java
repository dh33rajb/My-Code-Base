// Use of priority queue in Java

import java.util.*;
import java.lang.*;

public class PrioQueueExample {
    public static void main (String args[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer> (100, new Comparator<Integer> () {
            @Override
            public int compare (Integer intOne, Integer intTwo) {
                if (intOne > intTwo)
                    return -1;
                else if (intOne < intTwo)
                    return 1;
                else
                    return 0;
            }
        });
        Scanner scanner = new Scanner (System.in);
        while (scanner.hasNextInt()) {
            pq.add(scanner.nextInt());
        }
        System.out.println(pq);
    }
}
