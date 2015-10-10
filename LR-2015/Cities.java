import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cities {
	public static void main(String args[]) {
		System.out.println(Arrays.toString(citiesDistances(new int[] { 6, 5, 3,
				3, 3, 4, 4 })));
		System.out.println(Arrays.toString(citiesDistances(new int[] { 9, 1, 4,
				9, 0, 4, 8, 9, 0, 1 })));
	}

	public static int[] citiesDistances(int[] input) {
		if (input == null || input.length == 0)
			return null;
		int capital = Integer.MIN_VALUE;
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < input.length; i++) {
			int currVal = input[i];
			if (currVal == i)
				capital = i;
			else {
				List<Integer> neighbors = map.get(currVal);
				if (neighbors == null)
					neighbors = new ArrayList<Integer>();
				neighbors.add(i);
				map.put(input[i], neighbors);
			}
		}
		int level = 0;
		// System.out.println(map);
		return populateOutput(map, new int[input.length - 1], level, capital);
	}

	public static int[] populateOutput(Map<Integer, List<Integer>> map,
			int[] output, int level, int key) {
		if (level == output.length)
			return output;
		List<Integer> list = map.get(key);
		if (list != null) {
			output[level] = output[level] + list.size();
			for (int each : list)
				output = populateOutput(map, output, level + 1, each);
		}
		return output;
	}
}
