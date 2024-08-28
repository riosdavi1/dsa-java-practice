package codingtests.codinginterview.linkedlists;

import static util.ListNodes.sizeToList;

import java.util.Objects;

import datastructs.linkedlist.LinkedList;
import util.ListNodes;

public class DeleteMiddle {

	public static void main(String[] args) {
		LinkedList<Integer> head = sizeToList(5); // [1, 2, 3, 4, 5]
		LinkedList<Integer> middleNode = head.next().next().next(); // 4

		deleteMiddleNode(middleNode);

		assert ListNodes.toString(head).equals("[1, 2, 3, 5]");
	}
	
	private static void deleteMiddleNode(LinkedList<Integer> middleNode) {
		Objects.requireNonNull(middleNode.next());
		
		LinkedList<Integer> nextNode = middleNode.next();
		middleNode.setData(nextNode.getData());
		middleNode.next(nextNode.next());
	}
}
