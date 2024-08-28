package codingtests.codinginterview.linkedlists;

import datastructs.linkedlist.LinkedList;
import util.ListNodes;

import static util.ListNodes.valuesToList;

import java.util.HashSet;
import java.util.Set;

public class RemoveDups {

	public static void main(String[] args) {
		LinkedList<Integer> input = valuesToList(5, 2, 3, 4, 2, 1, 3);

		LinkedList<Integer> result = removeDups(input);

		assert ListNodes.toString(result).equals("[5, 2, 3, 4, 1]");
	}

	/*
	 * [5, 2, 3, 4, 2, 1, 3]
	 * 1. prev:head, head:5, set:[] -> set:[5], prev:head, head:head.next
	 * 2. head:2, set:[5] -> set:[5,2], prev:head, head:head.next
	 * 3. head:3, set:[5,2] -> set:[5,2,3], prev:head, head:head.next
	 * 4. head:4, set:[5,2,3] -> set:[5,2,3,4], prev:head, head:head.next
	 * 5. head:2, set:[5,2,3,4] -> set:[5,2,3,4], prev.next:head.next, head:head.next.next
	 * 6. head:3, set:[5,2,3,4] -> set:[5,2,3,4], prev.next:head.next, head:next:null -> list
	 * 
	 */
	private static LinkedList<Integer> removeDups(LinkedList<Integer> list) {
		Set<Integer> hashset = new HashSet<>();
		LinkedList<Integer> head = list;
		LinkedList<Integer> prev = list;
		while (head != null) {
			if (!hashset.contains(head.getData())) {
				hashset.add(head.getData());
				prev = head;
			} else {
				prev.next(head.next());
			}
			head = head.next();
		}
		return list;
	}
}
