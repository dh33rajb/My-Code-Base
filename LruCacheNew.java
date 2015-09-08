import java.io.*;
import java.util.*;

class Solution {
  public static void main(String[] args) {
    
    // Step-1: Define inputs
    int[] input = new int[] {2, 3, 4, 2, 1, 3, 7, 5, 4, 3};
    int cacheSize = 3;
    
    // Step-2: set to cache
    final Map<Integer, Integer> lruCache = new HashMap<Integer, Integer>();
    int count = 0;
    for (int i : input) {
      setKey (lruCache, i, count++);
      /* for (Map.Entry<Integer, Integer> e : lruCache.entrySet())
        System.out.print (e.getKey() + "-");
      System.out.println(); */
    }
    
    // Step-3: get from cache
    for (int i : input) {
      int value = getKey (lruCache, i);
      if (value == Integer.MIN_VALUE)
        System.out.println (i + "-" + null);
      else
        System.out.println (i + "-" + value);
    }
  }
  
  public static void setKey (Map<Integer, Integer> lruCache, int key, int value) { // key = number; value=index
    if (lruCache.get (key) != null) // number exists in cache.. update index
      lruCache.put (key, value);
    else if (lruCache.size() < 3) // cache size less than limit.. add new number
      lruCache.put (key, value);
    else { // eviction logic
      Iterator<Map.Entry<Integer, Integer>> itr = lruCache.entrySet().iterator();
      Map.Entry<Integer, Integer> lruEntry = null;
      while (itr.hasNext()) {
        Map.Entry<Integer, Integer> nextEntry = itr.next();
        if (lruEntry == null)
          lruEntry = nextEntry;
        else {
          if (nextEntry.getValue() < lruEntry.getValue()) {
            lruEntry = nextEntry;
          }
        }
      }
      lruCache.remove(lruEntry.getKey());
      lruCache.put(key, value);
    }
  }
  
  public static int getKey(Map<Integer, Integer> lruCache, int key) {
    if (lruCache.get(key)!= null)
      return lruCache.get (key);
    else
      return Integer.MIN_VALUE;
  }
}
