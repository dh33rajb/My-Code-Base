/*
https://leetcode.com/problems/two-sum/

Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2 

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
    
    public static void main (String args[]) {
        int[] output = twoSum (new int[] {2, 7, 11, 15}, 9);
        for (int  o: output)
            System.out.print (o + " ");
    }
    
	public static int[] twoSum(int[] nums, int target) {

		// Step-0: Initialization
		int i = 0;
		int j = nums.length - 1;
		int[] output = new int[2];
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

		// Step-1: Add inputs value and index to map. Key = number; value =
		// index+1.
		for (int k = 0; k < nums.length; k++) {
			int currNum = nums[k];
			if (map.get(currNum) == null)
				map.put(currNum, Arrays.asList(new Integer[] { k + 1 }));
			else {
				if ((currNum * 2) == target)
					return new int[] { map.get(currNum).get(0), k + 1 };
				List tempList = new ArrayList<Integer>(map.get(currNum));
				tempList.add(k + 1);
				map.put(currNum, tempList);
			}
		}
		Arrays.sort(nums); 

		while (i < j) {
			if ((nums[i] + nums[j]) == target) {
			    if (map.get(nums[i]).get(0) < map.get(nums[j]).get(0)) {
				    output[0] = map.get(nums[i]).get(0);
				    output[1] = map.get(nums[j]).get(0);
			    } else {
			        output[0] = map.get(nums[j]).get(0);
				    output[1] = map.get(nums[i]).get(0);
			    }
				break;
			} else if ((nums[i] + nums[j]) > target)
				j--;
			else
				i++;
		}
		return output;
	}
}
