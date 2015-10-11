import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// My equivalent of Hashtable class
class MyHashTable<K, V> {

	private int capacity;

	private List<List<MyEntry<K, V>>> cells;

	// Default constructor with auto-assigned capacity of 100
	public MyHashTable() {
		this(100);
	}

	// Constructor with user-defined capacity
	public MyHashTable(int capacity) {
		this.capacity = capacity;
		// ArrayList is used to hold the table as capacity can be pre-defined in
		// ArrayLists
		this.cells = new ArrayList<List<MyEntry<K, V>>>(this.capacity);
		int count = -1;
		while (++count < this.capacity)
			this.cells.add(null);
	}

	// Put method of MyHashTable
	public void put(K key, V value) {
		if (key == null || value == null)
			throw new NullPointerException("Null keys/values are not allowed");

		int cellIndex = this.hash(key);
		List<MyEntry<K, V>> cell = this.cells.get(cellIndex);
		if (cell == null)
			// LinkedList is used for each cell to chain keys during collisions
			cell = new LinkedList<MyEntry<K, V>>();
		else {
			// If key already exists, perform concurrent modification of value
			Iterator<MyEntry<K, V>> iterator = cell.iterator();
			MyEntry<K, V> entry = null;
			while (iterator.hasNext()) {
				entry = iterator.next();
				if (entry.key.equals(key)) {
					entry.value = value;
					return;
				}
			}
		}
		cell.add(new MyEntry<K, V>(key, value));
		this.cells.set(cellIndex, cell);
	}

	// Get method of MyHashTable
	public V get(K key) {
		if (key == null)
			throw new NullPointerException("Null keys are not allowed");

		int cellIndex = this.hash(key);
		List<MyEntry<K, V>> cell = this.cells.get(cellIndex);
		if (cell != null) {
			// key look-up: if key exists, return value; else, return null
			Iterator<MyEntry<K, V>> iterator = cell.iterator();
			MyEntry<K, V> entry = null;
			while (iterator.hasNext()) {
				entry = iterator.next();
				if (entry.key.equals(key))
					return entry.value;
			}
		}
		return null;
	}

	// Hash Function for MyHashTable.
	// The Hash Function is the same used in Java SDK HashMap class
	public int hash(K key) {
		return ((key.hashCode() & 0x7FFFFFFF) % this.capacity);
	}

	// My equivalent of Map.Entry class (a nested class)
	class MyEntry<K, V> {
		private K key;
		private V value;

		public MyEntry(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
}

// Driver class that uses MyHashTable
public class MyHashTableDriver {
	public static void main(String args[]) {
		MyHashTable<String, Integer> myHashTable = new MyHashTable<String, Integer>(
				1);
		myHashTable.put("a", 1);
		myHashTable.put("b", 2);
		myHashTable.put("c", 3);
		myHashTable.put("a", 11);
		myHashTable.put("b", 12);
		myHashTable.put("c", 13);
		// myHashTable.put("d", null);
		System.out.println(myHashTable.get("a"));
		System.out.println(myHashTable.get("b"));
		System.out.println(myHashTable.get("c"));
		System.out.println(myHashTable.get("d"));
		System.out.println(myHashTable.get("e"));

		MyHashTable<Integer, Integer> myOtherHashTable = new MyHashTable<Integer, Integer>(
				1);
		myOtherHashTable.put(1, 101);
		myOtherHashTable.put(2, 102);
		myOtherHashTable.put(3, 103);
		myOtherHashTable.put(1, 111);
		myOtherHashTable.put(2, 112);
		myOtherHashTable.put(3, 113);
		// myOtherHashTable.put(4, null);
		System.out.println(myOtherHashTable.get(1));
		System.out.println(myOtherHashTable.get(2));
		System.out.println(myOtherHashTable.get(3));
		System.out.println(myOtherHashTable.get(4));
		System.out.println(myOtherHashTable.get(5));
	}
}
