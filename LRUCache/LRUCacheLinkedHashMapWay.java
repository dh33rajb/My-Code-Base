import java.util.*;
import java.lang.*;

class LRUCache {

    private Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        map = new LinkedHashMap<Integer, Integer>(16, 0.75f, true) {
           private static final long serialVersionUID = 1L;
          @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void set(int key, int value) {
        map.put(key,value);
    }
}

class LRUCacheDriver {
  public static void main (String args[]) {
    LRUCache lru = new LRUCache (3);
    lru.set (1, 1);
    lru.set (2, 2);
    lru.set (3, 3);
    lru.set (2, 2);
    lru.set (1, 1);
    lru.set (4, 4);
    lru.set (6, 6);
    
    System.out.println (lru.get (2));
  }
}
