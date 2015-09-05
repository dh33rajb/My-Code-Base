/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Logic:
for (every element in input array)
    incl = prevExcl + current array element;
    excl = Math.max (prevIncl, prevExcl);

Input (Hardcoded for simplicity):
[5, 5, 10, 40, 50, 35]

Output:
0--5
5--5
5--15
15--45
45--65
65--80

80
*/
public class HouseRobberAdjacent {
    public static void main (String args[]) {
      int nums[] = new int [] {5, 5, 10, 40, 50, 35};
      int incl = 0;
      int excl = 0;
      for (int i=0; i<nums.length; i++) {
        int prevExcl = excl;
        int prevIncl = incl;
        excl = Math.max (prevIncl, prevExcl);
        incl = prevExcl + nums[i];
        System.out.println (incl + "--" + excl);
      }
      System.out.println ("Output: " + Math.max (incl, excl));
    }
}
