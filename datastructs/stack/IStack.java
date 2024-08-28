package datastructs.stack;

public interface IStack<E> {

	void push(E e);
	E peek();
	E pop();
	int size();
}
