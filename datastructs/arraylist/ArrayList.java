package datastructs.arraylist;

public class ArrayList<T> implements IArrayList<T> {

	private static final int INITIAL_CAPACITY = 10;
	private static final int EXPAND_FACTOR = 2;
	
	private int _size;
	private Object[] array;
	
	public ArrayList() {
		this(INITIAL_CAPACITY);
	}
	
	public ArrayList(int capacity) {
		if (capacity < 1) {
			throw new IllegalArgumentException("Capacity cannot be lower than 1");
		}
		this.array = new Object[capacity];
	}
	
	@Override
	public boolean add(T t) {
		if (this._size == this.array.length - 1) {
			expandArray();
		}
		this.array[this._size] = t;
		this._size++;
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		if (index >= this._size) {
			throw new IndexOutOfBoundsException();
		}
		return (T)this.array[index];
	}

	@Override
	public int size() {
		return this._size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(T t) {
		for (int i = 0; i < this._size; i++) {
			T element = (T)this.array[i];
			if (element != null && element.equals(t)) {
				return remove(i);
			}
		}
		return false;
	}

	@Override
	public boolean remove(int index) {
		if (index >= this._size) {
			throw new IndexOutOfBoundsException();
		}
		if (index == this._size - 1) {
			this.array[index] = null;
		} else {
			for (int i = index; i < this._size; i++) {
				this.array[i] = this.array[i+1];
			}
			this.array[this._size - 1] = null;
		}
		this._size--;
		return true;
	}

	private void expandArray() {
		this.expandArray(this.array.length * EXPAND_FACTOR);
	}
	
	private void expandArray(int newCapacity) {
		Object[] newArray = new Object[newCapacity];
		for (int i = 0; i < this.array.length; i++) {
			newArray[i] = this.array[i];
		}
		this.array = newArray;
	}
}
