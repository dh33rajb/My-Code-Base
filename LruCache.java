import java.util.HashMap;

public class LruCache {
	int capacity;
	HashMap<Integer, Nodee> map = new HashMap<Integer, Nodee>();
	Nodee head = null;
	Nodee end = null;

	public LruCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Nodee n = map.get(key);
			remove(n);
			setHead(n);
			return n.value;
		}

		return -1;
	}

	public void remove(Nodee n) {
		if (n.pre != null) {
			n.pre.next = n.next;
		} else {
			head = n.next;
		}

		if (n.next != null) {
			n.next.pre = n.pre;
		} else {
			end = n.pre;
		}

	}

	public void setHead(Nodee n) {
		n.next = head;
		n.pre = null;

		if (head != null)
			head.pre = n;

		head = n;

		if (end == null)
			end = head;
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			Nodee old = map.get(key);
			old.value = value;
			remove(old);
			setHead(old);
		} else {
			Nodee created = new Nodee(key, value);
			if (map.size() >= capacity) {
				map.remove(end.key);
				remove(end);
				setHead(created);

			} else {
				setHead(created);
			}

			map.put(key, created);
		}
	}
}

class Nodee {
	int key;
	int value;
	Nodee pre;
	Nodee next;

	public Nodee(int key, int value) {
		this.key = key;
		this.value = value;
	}
}
