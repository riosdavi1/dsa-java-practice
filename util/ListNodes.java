package util;

import java.util.ArrayList;
import java.util.List;

import datastructs.linkedlist.LinkedList;

public class ListNodes {

    public static String toString(LinkedList<Integer> head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.getData());
            head = head.next();
        }
        return list.toString();
    }

    public static LinkedList<Integer> valuesToList(int... values) {
		LinkedList<Integer> list = new LinkedList<>(0);
		for (int i = 0; i < values.length; i++) {
			list.add(values[i]);
		}
        return list.next();
    }

    public static LinkedList<Integer> sizeToList(int size) {
		LinkedList<Integer> list = new LinkedList<>(1);
        for (int i = 2; i <= size; i++) {
        	list.add(i);
        }
        return list;
    }
}
