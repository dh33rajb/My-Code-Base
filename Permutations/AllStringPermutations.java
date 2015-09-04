public class AllStringPermutations {

	public static void main(String args[]) {
		String str = "abcde";
		char[] charArr = str.toCharArray();
		boolean[] boolArr = new boolean[charArr.length];

		StringBuffer output = new StringBuffer();
		doPermute(charArr, boolArr, output, 0);
	}

	public static void doPermute(char[] charArr, boolean[] boolArr,
			StringBuffer output, int level) {
		if (level == charArr.length) {
			System.out.println(output.toString());
			return;
		}
		for (int i = 0; i < charArr.length; ++i) {
			if (boolArr[i])
				continue;
			output.append(charArr[i]);
			boolArr[i] = true;
			doPermute(charArr, boolArr, output, level + 1);
			boolArr[i] = false;
			output.setLength(output.length() - 1);
		}
	}
}
