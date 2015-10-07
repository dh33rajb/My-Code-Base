// Time complexity = O(NlogN) + O(DN) = O(NlogN)
// Didn't cover -1 case yet

import java.util.Map;
import java.util.TreeMap;

public class FrogJump {
	public static void main(String args[]) {
		System.out.println(frogJump(new int[] {1, 3, 4, 5, 6, 7, 9, 1, 4, 5, 6}, 9, 5));
	}

	public static int frogJump(int[] arr, int X, int D) {
		// Step-0: Base condition
		if (arr == null || arr.length == 0 || X <= D)
			return 0;

		// Step-1: Create TreeMap ==> key = sorted positions; value = time leaf falls on the position ==> O(NlogN) where N=size of array
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		map.put(0, 0);
		map.put(X, 0);
		for (int i = 0; i < arr.length; i++) {
			if (map.get(arr[i]) == null)
				map.put(arr[i], i);
		}
		System.out.println(map);

		// Step-2: Update TreeMap ==> key = sorted positions; value = best overall time to reach the position ==> O(DN)
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			int pos = e.getKey();
			int timeLeafFalls = e.getValue();
			if (pos > D) {
				int bestTime = Integer.MAX_VALUE;
				for (int step = 1; step <= D; step++) {
					if (map.get(pos - step) == null)
						continue;
					if (map.get(pos - step) < timeLeafFalls) {
						bestTime = timeLeafFalls;
						break;
					} else
						bestTime = Math.min(map.get(pos - step), bestTime);
				}
				// e.setValue(bestTime);
				if (bestTime == Integer.MAX_VALUE)
					bestTime = -1;
				map.put(pos, bestTime);
			}
		}
		System.out.println(map);
		return map.get(X);
	}
}
