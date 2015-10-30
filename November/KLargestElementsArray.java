// find Kth smallest elements in an array

import java.util.*;
import java.lang.*;

public class KLargestElementsArray {
  
  public static void main (String args[]) {
    System.out.println (kSmallest ((Arrays.asList(new Integer[] {1, 25, 9, 43, 5, 19, 4, 0, -1, -15})), 3));
  }

  public static List<Integer> kSmallest (List<Integer> input, int k) {
    // base case
    if (input == null || input.size() == 0)
      return input;
    
    if (k < 1)
      return new ArrayList<Integer>();
    
    // generic case
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(input.size(), new Comparator<Integer> () {
      @Override
      public int compare (Integer i, Integer j) {
        if (i < j)
          return 1;
        else if (i > j)
          return -1;
        else
          return 0;
      }
    });
    for (int i : input)
      pq.add (i);
    
    List<Integer> output = new ArrayList<Integer> ();
    for (int i=0; i < k; i++)
      output.add (pq.remove());
    
    return output;
  }
}
