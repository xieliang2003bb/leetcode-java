package copy_list_with_random_pointer;

import java.util.HashMap;

import common.RandomListNode;

public class CopyListwithRandomPointer {

    public class Solution {

        private RandomListNode getNewNode(
                HashMap<RandomListNode, RandomListNode> nodes,
                RandomListNode oldNode) {
            RandomListNode newNode = nodes.get(oldNode);
            if (newNode == null) {
                newNode = new RandomListNode(oldNode.label);
                nodes.put(oldNode, newNode);
            }
            return newNode;
        }

        public RandomListNode copyRandomList(RandomListNode head) {
            RandomListNode newHead = null;
            RandomListNode p = head;
            HashMap<RandomListNode, RandomListNode> nodes = new HashMap<RandomListNode, RandomListNode>();
            while (p != null) {
                RandomListNode newP = getNewNode(nodes, p);
                if (newHead == null) {
                    newHead = newP;
                }
                if (p.next != null) {
                    newP.next = getNewNode(nodes, p.next);
                }
                if (p.random != null) {
                    newP.random = getNewNode(nodes, p.random);
                }
                p = p.next;
            }
            return newHead;
        }
    }

    public static class UnitTest {

    }
}
