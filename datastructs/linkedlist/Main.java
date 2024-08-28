package datastructs.linkedlist;

import util.ListNodes;

public class Main {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>(1);
		for (int i = 2; i < 6; i++) {
			list.add(i);
		}
		assert ListNodes.toString(list).equals("[1, 2, 3, 4, 5]");
		list = list.remove(0);
		assert ListNodes.toString(list).equals("[2, 3, 4, 5]");
		LinkedList<Integer> node = list.get(2);
		assert ListNodes.toString(node).equals("[4, 5]");
		assert node.getData().equals(4);
	}

}
