import java.io.*;
import java.util.*;

/*
Input:
{1, 2, 2, 3, 4, 5, 5, 6, 7, 8}, 2

Output:
{1, 3, 4, 5, 5, 6, 7, 8}

*/

class RemoveValueFromList {
  public static void main(String[] args) {
    List<Integer> input = new LinkedList<Integer> (Arrays.asList(new Integer[] {1, 2, 2, 3, 4, 5, 5, 6, 7, 8}));
    
    System.out.println (removedValues(input, 2));
  }
  
  public static List<Integer> removedValues (List<Integer> list, int value) {
    if (list == null || list.size() == 0)
      return list;
    Iterator<Integer> itr = list.iterator();
    while (itr.hasNext()) {
      int next = itr.next();
      if (next == value)
        itr.remove ();
    }
    return list;
  }
}
