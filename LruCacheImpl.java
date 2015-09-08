// LRU CACHE IMPLEMENTATION
/*
Input:
------
int[] input = new int[] {2, 3, 4, 2, 1, 3, 7, 5, 4, 3};

Output: (after all operations)
------
2-null
3-9
4-8
2-null
1-null
3-9
7-null
5-7
4-8
3-9
*/

import java.io.*;
import java.util.*;

public class LruCacheDriver {
  public static void main(String[] args) {
    
    // Step-1: Define inputs
    int[] input = new int[] {2, 3, 4, 2, 1, 3, 7, 5, 4, 3};
    int cacheSize = 3;
    LruCache lruCache = new LruCache (cacheSize);
    
    // Step-2: set to cache
    int count = 0;
    for (int i : input)
      lruCache.setKey(i, count++);
    
    // Step-3: get from cache
    for (int i : input) {
      int value = lruCache.getKey (i);
      if (value == Integer.MIN_VALUE)
        System.out.println (i + "-" + null);
      else
        System.out.println (i + "-" + value);
    }
  }
}

class LruCache {
  
  public int size;
  public Map<Integer, Integer> lruCache;
  
  public LruCache (int size) {
    this.size = size;
    this.lruCache = new HashMap<Integer, Integer>();
  }
  
  public void setKey (int key, int value) { // key = number; value=index
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
  
  public int getKey(int key) {
    if (lruCache.get(key)!= null)
      return lruCache.get (key);
    else
      return Integer.MIN_VALUE;
  }
}
