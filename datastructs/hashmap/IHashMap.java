package datastructs.hashmap;

public interface IHashMap<K, V> {

	void put(K k, V v);
	V get(K k);
	int size();
	boolean remove(K k);
}
