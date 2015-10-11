package zenefits;

/*
 You are given a binary array with N elements: d[0], d[1], … d[N -1].
 You can perform AT MOST one move on the array: choose any two integers [L, R],
 and flip all the elements between (and including) the L-th and R-th bits. L and
 R represent the left-most and right-most index of the bits marking the
 boundaries of the segment which you have decided to flip.

 What is the maximum number of '1'-bits (indicated by S) which you can obtain in
 the final bit-string?
 'Flipping' a bit means, that a 0 is transformed to a 1 and a 1 is transformed to
 a 0

 Sample Input:
 8
 1 0 0 1 0 0 1 0
 Sample Output:
 6
 Sample Input:
 17
 0 0 0 0 0 1 0 0 0 0 0 1 1 1 1 1 0
 Sample Output:
 15

 Sample Input:
 11
 0 0 0 1 0 0 0 1 1 1 0
 Sample Output:
 9
 */

import java.util.Scanner;

public class BitsFlipTwo {

	public static void main(String args[]) {
		// Step-1: Read inputs
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++)
			nums[i] = scanner.nextInt();
		scanner.close();

		// Step-2: BitsFlip function invocation
		int output = bitsFlip(nums);
		System.out.println(output);
	}

	public static int bitsFlip(int[] nums) {
		// Step-1: Count zeros:
		// Find the 'least-width' left and right indices between whom ((# of zeros) - (# of ones)) is minimum
		int left = nums.length;
		int right = -1;
		int rightMinusLeft = Math.abs(right - left);
		int maxZeroMinusOneCount = 0;

		for (int i = 0; i < nums.length; i++) {
			int currZeroMinusOneCount = 0;
			for (int j = i; j < nums.length; j++) {
				if (nums[j] == 0)
					currZeroMinusOneCount++;
				else
					currZeroMinusOneCount--;
				if (currZeroMinusOneCount != 0
						&& ((currZeroMinusOneCount > maxZeroMinusOneCount)
								|| (currZeroMinusOneCount == maxZeroMinusOneCount && (j - i) < rightMinusLeft))) {
					maxZeroMinusOneCount = currZeroMinusOneCount;
					left = i;
					right = j;
					rightMinusLeft = j - i;
				}
			}
		}
		System.out.println(left + "-" + right + "--" + maxZeroMinusOneCount);
		
		// Step-2: Find the final count of ones by flipping all data between left and right
		int oneBitsCount = 0;
		for (int i = 0; i < nums.length; i++) {
			if (((i < left || i > right) && nums[i] == 1)
					|| (i >= left && i <= right && nums[i] == 0))
				oneBitsCount++;
		}
		return (oneBitsCount);
	}
}
