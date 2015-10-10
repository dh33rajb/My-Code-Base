import java.util.Arrays;

public class Sequence {
	public static void main(String args[]) {
		System.out.println(maxSubSequence(new int[] {-1, -1, 1, 1, 0, 0, 1, -1, -1}));
	}

	// Time complexity: O(NlogN); Space complexity: O(1)
	public static int maxSubSequence(int[] arr) {
		if (arr == null || arr.length == 0)
			return 0;
		// Step-1: Sort arrays ==> O(NlogN)
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));

		// Step-2: length of longest sub-array with amplitude <= 1 ==> O(N)
		int diff = 0;
		int maxLen = 0;
		int prevLen = 0;
		int currLen = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != arr[i - 1]) {
				prevLen = currLen - prevLen;
				if (arr[i] - arr[i - 1] + diff > 1) {
					if (arr[i] != arr[i - 1] + 1) {
						diff = 0;
						prevLen = 0;
					}
					maxLen = Math.max(currLen, maxLen);
					currLen = prevLen;
				}
				// System.out.println(prevLen + "--" + currLen + "--" + i);
			}
			diff = diff + (arr[i] - arr[i - 1]);
			currLen++;
		}
		return Math.max(currLen, maxLen);
	}
}
