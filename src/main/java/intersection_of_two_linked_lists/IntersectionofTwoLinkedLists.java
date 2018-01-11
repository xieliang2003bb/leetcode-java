package intersection_of_two_linked_lists;

import common.ListNode;

public class IntersectionofTwoLinkedLists {

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) return null;
            ListNode a = headA, b = headB;
            while (a != b) {
                a = (a != null) ? a.next : headB;
                b = (b != null) ? b.next : headA;
            }
            return a;  // either intersection or null
        }
    }

    public static class UnitTest {

    }
}

