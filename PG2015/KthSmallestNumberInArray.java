// find the k'th smalest number in an array

import java.util.*;
import java.lang.*;

public class KthSmallestNumberInArray {
  public static void main (String args[]) {
    System.out.println (kthSmallest (new int[] {100, 89, 134, 1818, 46, 6969, 36, 98, 12, 1} , 8));
  }
  
  public static int kthSmallest (int a[], int k) {
    // base case
    if (a == null || a.length == 0 || k <= 0 || k > a.length)
      return -1;
  
    // generic case
    PriorityQueue<Integer> pq = new PriorityQueue<Integer> ();
    for (int each : a)
      pq.add (each);
    
    while (k > 1) {
      pq.remove ();
      k--;
    }
    return pq.remove ();
  }
}
