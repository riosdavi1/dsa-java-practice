package codingtests.leetcode.lists;
import util.ListNodes;
import static util.ListNodes.sizeToList;

import datastructs.linkedlist.LinkedList;

/**
 * https://leetcode.com/problems/reverse-linked-list/description/
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        assert ListNodes.toString(reverseList(sizeToList(5))).equals("[5, 4, 3, 2, 1]");
        assert ListNodes.toString(reverseList(sizeToList(2))).equals("[2, 1]");
    }

    /*
     * 0. reserved: new(0, null)
     * 1. head: 1 -> node1: new(1), node1.next: reserved.next -> head = head.next,
     * reserved.next: node1
     * 2. head: 2 -> node2: new(2), node2.next: reserved.next -> head = head.next,
     * reserved.next: node2
     * 3. ...
     * 5. head: 5 -> node5: new(5), node5.next: reserved.next -> head = head.next,
     * reserved.next: node5
     * 6. head: null -> return reversed.next
     */
    public static LinkedList<Integer> reverseList(LinkedList<Integer> head) {
        LinkedList<Integer> reversed = new LinkedList<>(0);
        while (head != null) {
            LinkedList<Integer> node = new LinkedList<>(head.getData(), reversed.next());
            reversed.next(node);
            head = head.next();
        }
        return reversed.next();
    }
}
