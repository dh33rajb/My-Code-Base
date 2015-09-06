// Find all permutations of a string using DYNAMIC PROGRAMMING
/*
Input (Hardcoded):
abc

Output:
abc
acb
bac
bca
cba
cab
*/
public class AllStringPermutationsRecursionTwo {
	public static void main(String args[]) {
		String input = "abc";
		char[] inputArr = input.toCharArray();
		printAllPermutations(inputArr, 0, inputArr.length);
	}

	public static void printAllPermutations(char[] inputArr, int startIndex,
			int endIndex) {
		if (startIndex == endIndex) {
			String output = "";
			for (int i = 0; i < endIndex; i++)
				output = output + inputArr[i];
			System.out.println(output);
		}
		for (int i = startIndex; i < endIndex; i++) {
			char temp = inputArr[startIndex];
			inputArr[startIndex] = inputArr[i];
			inputArr[i] = temp;
			printAllPermutations(inputArr, startIndex + 1, endIndex);
			temp = inputArr[startIndex];
			inputArr[startIndex] = inputArr[i];
			inputArr[i] = temp;
		}

	}
}

