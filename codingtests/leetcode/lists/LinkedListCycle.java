package codingtests.leetcode.lists;
import static util.ListNodes.valuesToList;

import datastructs.linkedlist.LinkedList;

/**
 * https://leetcode.com/problems/linked-list-cycle/description/
 */
public class LinkedListCycle {

    public static void main(String[] args) {
        assert detectCycle(cycleList1()).getData() == 2;
        assert detectCycle(cycleList2()).getData() == 1;
        assert detectCycle(valuesToList(1)) == null;
        assert detectCycle(valuesToList()) == null;
    }

    /*
     * 
     * current: (2), current.next: (0) -> prev: (3), prev: (2)
     * current: (0), current.next: (-4) -> prev: (3), prev: (2), prev: (0)
     * current: (-4), current.next: (2) -> prev: (3), prev: (2) -> return (2)
     * 
     */
    public static LinkedList<Integer> detectCycle(LinkedList<Integer> head) {
        LinkedList<Integer> slowPointer = head, fastPointer = head;

        while (fastPointer != null && fastPointer.next() != null) {
            slowPointer = slowPointer.next();
            fastPointer = fastPointer.next().next();
            if (fastPointer == slowPointer) {
                slowPointer = head;
                while (fastPointer != slowPointer) {
                    slowPointer = slowPointer.next();
                    fastPointer = fastPointer.next();
                }
                return slowPointer;
            }
        }

        return null;
    }

    private static LinkedList<Integer> cycleList1() {
        LinkedList<Integer> list = new LinkedList<>(3);
        LinkedList<Integer> node2 = new LinkedList<>(2);
        list.add(node2);
        list.add(0);
        LinkedList<Integer> node4 = new LinkedList<>(-4, node2);
        list.add(node4);
        return list;
    }

    private static LinkedList<Integer> cycleList2() {
        LinkedList<Integer> list = new LinkedList<>(1);
        LinkedList<Integer> node2 = new LinkedList<>(2, list);
        list.add(node2);
        return list;
    }
}
