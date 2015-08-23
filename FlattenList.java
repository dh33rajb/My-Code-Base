// Flatten a Linked List Java
import java.util.*;
import java.lang.*;

public class FlattenList {
    public static void main (String args[]) {
        // Step-0: Set-up inputs
        List<List<Integer>> input = new ArrayList<List<Integer>> ();
        List<Integer> l1 = Arrays.asList (new Integer[] {4, 5});
        List<Integer> l2 = Arrays.asList (new Integer[] {1, 2, 3});
        List<Integer> l3 = Arrays.asList (new Integer[] {8, 9, 10});
        List<Integer> l4 = Arrays.asList (new Integer[] {6, 7});
        List<Integer> l5 = Arrays.asList (new Integer[] {11, 12});
        input.add (l1);input.add (l2);input.add (l3);input.add (l4);input.add (l5);
        System.out.println (input);
        
        // Step-2: Core logic
        List <Integer> output = mergeAllLists (input, 0);
        System.out.println (output);
    }
    
    public static List<Integer> mergeAllLists (List<List<Integer>> input, int index) {
        List <Integer> output = new ArrayList <Integer> ();
        if (input == null || input.size() == 0)
            return new ArrayList<Integer> ();
        if (index == input.size()-1)
            return input.get (index);
        output = mergeTwoLists (input.get (index), mergeAllLists (input, index+1));
        return output;
    }
    
    public static List<Integer> mergeTwoLists (List<Integer> listOne, List<Integer> listTwo) {
        List <Integer> outputList = new ArrayList<Integer> ();
        int i=0;
        int j=0;
        while (i < listOne.size() || j < listTwo.size()) {
            if (i == listOne.size()) {
                outputList.add (listTwo.get (j));
                j++;
            } else if (j == listTwo.size()) {
                outputList.add (listOne.get (i));
                i++;
            } else {
                if (listOne.get (i) <= listTwo.get (j)) {
                    outputList.add (listOne.get(i));
                    i++;
                } else {
                    outputList.add (listTwo.get(j));
                    j++;
                }
            }
        }
        return outputList;
    }
}
