import java.util.Scanner;

public class BitsFlip {

	public static void main(String args[]) {
		// Step-1: Read inputs
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++)
			nums[i] = scanner.nextInt();
		scanner.close();

		// Step-2: BitsFlip method invocation
		int output = bitsFlip(nums);
		System.out.println(output);
	}

	public static int bitsFlip(int[] nums) {
		// Step-1: Find the least width left and right indices between whom
		// there are
		// maximum number of zeros
		int left = nums.length;
		int right = -1;
		int rightMinusLeft = Math.abs(right - left);
		int maxZeroCount = 0;

		for (int i = 0; i < nums.length; i++) {
			int currZeroCount = 0;
			for (int j = i; j < nums.length; j++) {
				if (nums[j] == 0)
					currZeroCount++;
				if (currZeroCount != 0
						&& (currZeroCount > maxZeroCount || (currZeroCount == maxZeroCount && (j - i) < rightMinusLeft))) {
					maxZeroCount = currZeroCount;
					left = i;
					right = j;
					rightMinusLeft = j - i;
				}
			}
		}
		// System.out.println(left + "-" + right);
		// Step-2: Find the final count of ones
		int oneBitsCount = 0;
		for (int i = 0; i < nums.length; i++) {
			if (((i < left || i > right) && nums[i] == 1)
					|| (i >= left && i <= right && nums[i] == 0))
				oneBitsCount++;
		}
		return (oneBitsCount);
	}
}
