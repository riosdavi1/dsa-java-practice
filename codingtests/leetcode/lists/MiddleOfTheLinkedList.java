package codingtests.leetcode.lists;
import util.ListNodes;
import static util.ListNodes.sizeToList;

import datastructs.linkedlist.LinkedList;

/**
 * https://leetcode.com/problems/middle-of-the-linked-list/description/
 */
public class MiddleOfTheLinkedList {

    public static void main(String[] args) {
        // [1, 2, 3, 4, 5]
        assert ListNodes.toString(middleNode(sizeToList(5))).equals("[3, 4, 5]");
        // [1, 2, 3, 4, 5, 6]
        assert ListNodes.toString(middleNode(sizeToList(6))).equals("[4, 5, 6]");
    }

    private static LinkedList<Integer> middleNode(LinkedList<Integer> head) {
        LinkedList<Integer> lastNode = head;
        LinkedList<Integer> middleNode = head;

        while (lastNode != null && lastNode.next() != null) {
            middleNode = middleNode.next();
            lastNode = lastNode.next().next();
        }

        return middleNode;
    }
}
