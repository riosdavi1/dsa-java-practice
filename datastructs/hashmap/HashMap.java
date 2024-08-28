package datastructs.hashmap;

import java.util.Objects;

public class HashMap<K, V> implements IHashMap<K, V> {
	
	private static final int DEFAULT_CAPACITY = 10;

	private int _size;
	
	private PairLinkedList<K,V>[] array;
	
	public HashMap() {
		this(DEFAULT_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public HashMap(int capacity) {
		this.array = new PairLinkedList[capacity];
	}
	
	@Override
	public void put(K key, V value) {
		Objects.requireNonNull(key, "Key cannot be null");
		int hash = hashcode(key);
		int index = hash % this.array.length;
		PairLinkedList<K, V> head = this.array[index];
		if (head == null) {
			head = new PairLinkedList<>(key, value);
			this.array[index] = head;
			_size++;
		} else {
			PairLinkedList<K, V> iter = head;
			while (iter != null) {
				if (iter.getKey().equals(key)) {
					throw new IllegalArgumentException("Key already exists!");
				}
				iter = iter.next();
			}
			PairLinkedList<K, V> newPair = new PairLinkedList<>(key, value);
			newPair.next(head.next());
			head.next(newPair);
		}
	}

	@Override
	public V get(K key) {
		Objects.requireNonNull(key, "Key cannot be null");
		int hash = hashcode(key);
		int index = hash % this.array.length;
		PairLinkedList<K, V> head = this.array[index];
		while (head != null) {
			if (head.getKey().equals(key)) {
				return head.getValue();
			}
			head = head.next();
		}
		return null;
	}
	
	@Override
	public int size() {
		return this._size;
	}
	
	@Override
	public boolean remove(K key) {
		int hash = hashcode(key);
		int index = hash % this.array.length;
		PairLinkedList<K, V> head = this.array[index];
		PairLinkedList<K, V> prev = head;
		while (head != null) {
			if (head.getKey().equals(key)) {
				if (prev != head) {
					prev.next(head.next());
				} else {
					this.array[index] = null;
				}
				return true;
			}
			prev = head;
			head = head.next();
		}
		return false;
	}
	
	private int hashcode(K key) {
		return Objects.hashCode(key);
	}

}
