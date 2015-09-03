/*
Implement a hash map.

Logic.. we will use a simple hash function of the ascii value of the first character in the string

Ex:

Input:
Apple, 0
Banana, 1
Cat, 2
Dog, 3
Elephant, 4
Alien, 5
Christmas, 6
Denver, 7
zebra, 8
xavi, 9
james, 10

Output:
The HashTable's 0 th index has pair: Apple-0
The HashTable's 0 th index has pair: Alien-5
The HashTable's 1 th index has pair: Banana-1
The HashTable's 2 th index has pair: Cat-2
The HashTable's 2 th index has pair: Christmas-6
The HashTable's 3 th index has pair: Dog-3
The HashTable's 3 th index has pair: Denver-7
The HashTable's 4 th index has pair: Elephant-4
The HashTable's 9 th index has pair: james-10
The HashTable's 23 th index has pair: xavi-9
The HashTable's 25 th index has pair: zebra-8

*/

import java.util.*;
import java.lang.*;

public class HashMapStringsImpl {
    public static void main (String args[]) {
        
        // Step-1: Initialization
        List <List<Bucket>> hashTable = new ArrayList <List<Bucket>>();
        for (int i=0; i < 27; i++)
            hashTable.add (null);
            
        // Step-2: Reading inputs to insert into HashMap
        Scanner scanner = new Scanner (System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String [] lineSplit = line.split (",");
            Bucket bucket = new Bucket (lineSplit[0], Integer.valueOf(lineSplit[1].trim()));
            int tableIndex = hashFunction (lineSplit[0]);
            List<Bucket> bucketList = null;
            if (hashTable.get (tableIndex) == null)
                bucketList = new LinkedList <Bucket> ();
            else
                bucketList = hashTable.get (tableIndex);
                
            bucketList.add (bucket);
            hashTable.set (tableIndex, bucketList);
        }
        
        // Step-3: Verifying the results
        for (int i=0; i < 27; i++) {
            if (hashTable.get (i) != null) {
                for (int j=0; j < hashTable.get (i).size(); j++) {
                    Bucket b = hashTable.get (i).get (j);
                    System.out.println ("The HashTable's " + i + " th index has pair: " + b.key + "-" + b.value );
                }
            }
        }
    }
    
    public static int hashFunction (String key) {
        int index = 27;
        if (key != "") {
            key = key.toLowerCase ();
            char firstChar = key.charAt (0);
             index = firstChar - 97;
        }
        return index;
    }
}

class Bucket {
    public String key;
    public int value;
    
    public Bucket (String key, int value) {
        this.key = key;
        this.value = value;
    }
}
