// find kth fibbonnacci number

public class FibbonnacciNumberRecursionAndIterative {
  
  public static void main (String args[]) {
    System.out.println (findFibbonnacciRecursion (3));
    System.out.println (findFibbonnacciIterative (3));
  }
  
  public static int findFibbonnacciRecursion (int k) {
    // base or exit conditions
    if (k == 1)
      return 0;
    if (k == 2)
      return 1;
    return findFibbonnacciRecursion (k - 1) + findFibbonnacciRecursion (k - 2);
  }
  
  public static int findFibbonnacciIterative (int k) {
    // base conditions
    if (k == 1)
      return 0;
    if (k == 2)
      return 1;
    
    // generic case - DP
    int[] fib = new int[2];
    fib[0] = 0;
    fib[1] = 1;
    
    for (int i=2; i < k; i++) {
      int temp = fib [0];
      fib[0] = fib [1];
      fib[1] = temp + fib[1];
    }
    return fib[1];
  }
}
