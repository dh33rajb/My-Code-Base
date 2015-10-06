/* 
Uneaten leaves - Caterpillar problem
-------------------------------------
http://codereview.stackexchange.com/questions/95145/caterpillar-uneaten-leaves

Input:

    N = No of uneaten leaves
    K = No. of caterpillars
    A = Array of integer jump numbers

Output:
    The integer nu. Of uneaten leaves

Sample Input:
    10
    3
    2
    4
    5
Output:
    4

Explanation:

    [2, 4, 5] is a j member jump numbers, all leaves which are multiple of 2, 4, and 5 are eaten, leaves 1,3,7,9 are left, and thus the no. 4

*/

import java.util.*;
import java.lang.*;

public class UneatenLeaves {
    
    public static void main (String args[]) {
        // Step-1: Read inputs
        Scanner scanner = new Scanner (System.in);
        int numOfLeaves = scanner.nextInt();
        int numOfCaters = scanner.nextInt();
        int [] caterJumpArr = new int[numOfCaters];
        
        for (int i=0; i < numOfCaters; i++)
            caterJumpArr[i] = scanner.nextInt();
        scanner.close();
        
        // Step-2: Call core function
        int result = findUneatenLeaves (numOfLeaves, caterJumpArr);
        System.out.println (result);
    }
    
    public static int findUneatenLeaves (int numOfLeaves, int [] caterJumpArr) {
        boolean[] boolArr = new boolean [numOfLeaves+1];
        
        for (int cater : caterJumpArr) {
            int multiple = cater;
          do {
              boolArr[multiple] = true;
              multiple = multiple + cater;
          }  while (multiple <= numOfLeaves);
        }
        
        int count = 0;
        int index=0;
        for (boolean bool : boolArr) {
            if (bool) {
                System.out.println ("i " + index);
                count++;
            }
            index++;
        }
        return (numOfLeaves - count);
    }
}
