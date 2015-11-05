import java.io.*;
import java.util.*;

class ArrayOfNumbersThatFormASum {

  public static void main (String args[]) {
    recurse (10, new ArrayList<Integer>(), 0);
  }

  public static void recurse (int n, List<Integer> list, int sum) {
    if (sum == n) {
      System.out.println (list);
      return;
    }
    for (int i=1; i <= n; i++) {
      sum = sum + i;
      // System.out.println (sum + "--" + i);
      if (sum > n)
        break;
      List<Integer> newlist = new ArrayList <Integer> ();
      newlist.addAll (list);
      newlist.add(i);
      recurse (n, newlist, sum);
      sum = sum - i;
    }
  }
}
