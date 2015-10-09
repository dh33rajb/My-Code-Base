package com.liveramp;

import java.util.Arrays;

public class FrogJumpTwo {
	public static void main(String args[]) {
		// Step-1: Driver calls
		System.out.println(frogJump(new int[] { 0, 4, 5, 6, 7 }, 8, 2));
		System.out.println(frogJump(new int[] { 2, 3, 1, 4, 7, 5 }, 7, 5));
		System.out.println(frogJump(new int[] { 4, 2, 3, 1 }, 7, 4));
		System.out.println(frogJump(new int[] { 1, 3, 4, 5, 7, 2, 1, 4, 5, 6 },
				8, 6));
	}

	// Time complexity: O(XD), approaches O(X) if D <<< X; Space complexity: O(X)
	public static int frogJump(int[] arr, int X, int D) {
		// Step-1: Create arrays of: 1) all "positions" from 0 to X, and
		// 2) "times" when the leaf falls into each of those positions. ==> O(X)

		int[] positions = new int[X + 1];
		for (int i = 0; i <= X; i++)
			positions[i] = i;

		int[] times = new int[X + 1];
		Arrays.fill(times, Integer.MAX_VALUE);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= X && times[arr[i]] == Integer.MAX_VALUE)
				times[arr[i]] = i;
		}
		times[X] = 0;

		// System.out.println(Arrays.toString(positions));
		// System.out.println(Arrays.toString(times));

		// Step-2: Modify "times" array using DP, so it now has the "best times"
		// to reach each of the positions in the positions array ==> O(XD)
		for (int pos = 0; pos < positions.length; pos++) {
			int time = times[pos];
			if (time == Integer.MAX_VALUE)
				continue;
			if (pos > D) {
				int bestTime = Integer.MAX_VALUE;
				boolean noPrevStep = true;
				for (int step = 1; step <= D; step++) {
					if (times[pos - step] == Integer.MAX_VALUE
							|| times[pos - step] == -1)
						continue;
					noPrevStep = false;
					if (times[pos - step] < time) {
						bestTime = time;
						break;
					} else
						bestTime = Math.min(times[pos - step], bestTime);
				}
				if (bestTime == Integer.MAX_VALUE || noPrevStep)
					bestTime = -1;
				times[pos] = bestTime;
			}
		}
		// System.out.println(Arrays.toString(times));
		// Step-3: Return the best time to reach the destination: output
		return times[X];
	}
}

// Note: Time complexity of O(N) is infeasible, as far as I understand. O(XD)
// and O(NlogN) are two efficient solutions that come to my mind.
