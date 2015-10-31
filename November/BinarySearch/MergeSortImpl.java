import java.io.*;
import java.util.*;

// merge sort --> partition subroutine and merge routine
public class MergeSortImpl {
  public static void main(String[] args) {
    System.out.println (Arrays.toString(mergeRoutine (new int[] {2, 4, 6, 8}, new int[]{1, 3, 5, 7, 9})));
    
    int[] input = new int[] {0, 3, -7, 8, 11, 4, 90, 113, 51, 2, -1};
    
    System.out.println (Arrays.toString(partitionRoutine (input, 0, input.length-1)));
  }
  
  public static int[] partitionRoutine (int[] input, int start, int end) {
    if (start == end)
      return new int[] {input[start]};
    
    int mid = (start + end ) / 2;

    int a[] = partitionRoutine (input, start, mid);
    int b[] = partitionRoutine (input, mid+1, end);
    int c[] = mergeRoutine (a, b);
    
    return c;
  }
  
  public static int[] mergeRoutine (int[] a, int[] b) {
    if (a == null && b == null)
      return null;
    else if (a == null)
      return b;
    else if (b == null)
      return a;
    
    int i=0;
    int j=0;
    
    int[] c = new int[a.length + b.length];
    int k = 0;
    
    while (i < a.length || j < b.length) {
      if (i == a.length)
        c[k++] = b[j++];
      else if (j == b.length)
        c[k++] = a[i++];
      else if (a[i] < b[j])
        c[k++] = a[i++];
      else
        c[k++] = b[j++];
    }
    return c;
  }
}
