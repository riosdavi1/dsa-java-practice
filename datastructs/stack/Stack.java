package datastructs.stack;

import datastructs.linkedlist.LinkedList;

public class Stack<E> implements IStack<E> {

	private LinkedList<E> head;
	private int size;
	
	@Override
	public void push(E e) {
		LinkedList<E> node = new LinkedList<>(e);
		if (head == null) {
			head = node;
		} else {
			node.next(head);
			head = node;
		}
		size++;
	}

	@Override
	public E peek() {
		if (head != null) {
			return head.getData();
		}
		return null;
	}

	@Override
	public E pop() {
		if (head != null) {
			LinkedList<E> node = head;
			head = head.next();
			size--;
			return node.getData();
		}
		return null;
	}

	@Override
	public int size() {
		return size;
	}	
}
