package datastructs.hashmap;

public class PairLinkedList<K, V> {

	private K key;
	private V value;
	private PairLinkedList<K, V> _next;
	
	public PairLinkedList(K key, V value) {
		this(key, value, null);
	}
	
	public PairLinkedList(K key, V value, PairLinkedList<K, V> next) {
		this.key = key;
		this.value = value;
		this._next = next;
	}
	
	public PairLinkedList<K, V> next() {
		return this._next;
	}
	
	public void next(PairLinkedList<K, V> next) {
		this._next = next;
	}
	
	public K getKey() {
		return this.key;
	}
	
	public V getValue() {
		return this.value;
	}
}
