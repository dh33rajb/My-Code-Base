// http://www.geeksforgeeks.org/count-ways-reach-nth-stair/
/*
You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top? 

#ways to reach nth stair = #ways to reach (n-1)th stair + #ways to reach (n-2)th stair

ways (n) = ways (n-1) + ways (n-2)
This is SIMILAR to fibonnacci series ==> ways(n) == fib (n+1)

ways to reach 1 stair = 1
ways to reach 2 stairs = 2
ways to reach 3 stairs  = 3
ways to reach 4 stairs = 5
*/

public class WaysToClimbNStairs {
    public static void main (String args[]) {
      int n = 4; // number of stairs
      if (n==0)
        return;
      int[] fibArr = new int[2];
      fibArr[0] = 1;
      fibArr[1] = 1;
      while ((n-1) > 0) {
        int temp = fibArr[0];
        fibArr[0] = fibArr[1];
        fibArr [1] = temp + fibArr[1];
        n--;
      }
      System.out.println (fibArr[1]);
    }
}
