// Implement hashmap
/* 
Input:
1:2
2:3
3:4
4:5
5:6

Output:
4-->5
*/

import java.util.*;
import java.lang.*;

public class HashMapImpl {
    
    public static List <List <String[]>> map;
    public static void main (String args[]) {
        // Step-1: Initialization
        map = new ArrayList <List<String[]>>();
        for (int i=0; i<10; i++) {
            map.add (new ArrayList <String[]>());
        }
        
        // Step-2: Read inputs
        Scanner scanner = new Scanner (System.in);
        while (scanner.hasNext()) {
            String nextData = scanner.next();
            String[] keyValuePair = nextData.split (":");
            addToHashMap (keyValuePair);
        }
        
        // Step-3: testing code
        // hardocded here for quick test. it's straight forward to get this from console too.
        String pair[] = getKeyValuePairFromMap(4);
        if (pair != null)
            System.out.println (pair[0] + "-->" + pair[1]);
        
    }
    
    public static void addToHashMap (String[] keyValuePair) {
        int key = Integer.parseInt (keyValuePair[0]);
        int hashCode = getHashCode (key);
        List <String[]> data = map.get (hashCode);
        if (data == null)
            data = new ArrayList<String[]> ();
        data.add (keyValuePair);
        map.set (hashCode, data);
    }
    
    public static int getHashCode (int key) {
        return (key % 10);
    }
    
    public static String[] getKeyValuePairFromMap (int key) {
        int hashCode = getHashCode (key);
        List <String[]> data = map.get (hashCode);
        for (String[] pair : data) {
            if (Integer.parseInt (pair[0]) == key)
                return pair;
        }
        return null;
    }
}








