//Given all permutations of a string, give their lexicographical ranked order.
/*
 Input:
 dcba abcd abdc dacb acbd acdb adbc cbda adcb bacd badc dcab bcad bcda bdac bdca cabd cadb cbad cdab cdba dabc dbac dbca dcab

 Output:
 InputList: [dcba, abcd, abdc, dacb, acbd, acdb, adbc, cbda, adcb, bacd, badc, dcab, bcad, bcda, bdac, bdca, cabd, cadb, cbad, cdab, cdba, dabc, dbac, dbca, dcab]
 Rank List: [24, 1, 2, 20, 3, 4, 5, 16, 6, 7, 8, 23, 9, 10, 11, 12, 13, 14, 15, 17, 18, 19, 21, 22, 23]
 */
import java.util.*;
import java.lang.*;

public class AllPermutationsLexicographicalRank {
    
    public static int counter;
    
    public static Map<String, Integer> map;
    
    public static void main(String args[]) {
	    // Step-0: Initialization
	    counter = 1;
	    map = new HashMap<String, Integer> ();
	    
		// Step-1: Read input from console
		List<String> inputList = new ArrayList<String>();
		Scanner scanner = new Scanner (System.in);
		while (scanner.hasNext())
			inputList.add (scanner.next());
		
		// Step-2: Find the base string - the lowest ranked string. Ex: abcd
		char[] inputCharArr =  inputList.get(0).toCharArray();
		Arrays.sort(inputCharArr);
		String input = String.valueOf(inputCharArr);
		System.out.println (input);
		
		// Step-3: Core logic: Find lexicographical rank
		computeAllPermutationsWithRank(input.toCharArray(), new boolean[input.length()], new StringBuilder(""), 0);
		
		// Step-4: Create a list of rank for the input list
		List<Integer> rankList = new ArrayList<Integer>();
		for (String s : inputList)
		    rankList.add (map.get(s));
		    
		 // Step-4: print the outputs
		 System.out.println ("InputList: " + inputList);
		 System.out.println ("Rank List: " + rankList);
	}
	
	// Computing all permutations of the base string and ranking them. The results are saved within a map.
	public static void computeAllPermutationsWithRank (char[] inputArr, boolean[] boolArr, StringBuilder output, int level) {
	    if (level == inputArr.length) {
	        map.put (output.toString(), counter++);
	        //System.out.println (output.toString() + "--" + (counter-1));
	        return;
	    }
	    for (int i=0; i < inputArr.length; i++) {
	        if (boolArr[i])
	            continue;
	        boolArr[i] = true;
	        output.append(inputArr[i]);
	        computeAllPermutationsWithRank (inputArr, boolArr, output, level+1);
	        boolArr[i] = false;
	        output.setLength(output.length()-1);
	    }
	}
}
