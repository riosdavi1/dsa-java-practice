package datastructs.arraylist;

public interface IArrayList<T> {

	boolean add(T t);
	T get(int index);
	int size();
	boolean remove(T t);
	boolean remove(int index);
}
