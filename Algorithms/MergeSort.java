import java.util.Arrays;

public class MergeSort {

	public static void main(String args[]) {
		int[] input = new int[] { 1, 5, 6, 9, 3, 4, 2, 8, 7 };
		int[] output = partitionRoutine(input, 0, input.length - 1);
		System.out.println(Arrays.toString(output));
	}

	public static int[] partitionRoutine(int[] input, int start, int end) {
		if (start >= end)
			return input;
		System.out.println("Input: " + Arrays.toString(input));
		int mid = start + (end - start) / 2;
		System.out.println(start + "-" + mid + "-" + end);
		int[] arrOne = Arrays.copyOfRange(input, start, mid + 1);
		int[] arrTwo = Arrays.copyOfRange(input, mid + 1, end + 1);
		int output[] = mergeRoutine(
				partitionRoutine(arrOne, 0, arrOne.length - 1),
				partitionRoutine(arrTwo, 0, arrTwo.length - 1));
		System.out.println("Output: " + Arrays.toString(output));
		return output;
	}

	public static int[] mergeRoutine(int[] arrOne, int[] arrTwo) {
		// base case
		if (arrOne.length == 0)
			return arrTwo;
		if (arrTwo.length == 0)
			return arrTwo;

		// generic case
		int[] output = new int[arrOne.length + arrTwo.length];
		int k = 0;
		int i = 0;
		int j = 0;
		while (i != arrOne.length || j != arrTwo.length) {
			if (i == arrOne.length) {
				output[k++] = arrTwo[j++];
				continue;
			} else if (j == arrTwo.length) {
				output[k++] = arrOne[i++];
				continue;
			}

			if (arrOne[i] < arrTwo[j])
				output[k++] = arrOne[i++];
			else if (arrTwo[j] < arrOne[i])
				output[k++] = arrTwo[j++];
			else {
				output[k++] = arrOne[i++];
				output[k++] = arrTwo[j++];
			}
		}
		return output;
	}
}
