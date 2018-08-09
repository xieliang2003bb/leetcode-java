package remove_duplicates_from_sorted_list_ii;

import common.ListNode;

public class RemoveDuplicatesfromSortedListII {

    public class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) return head;

            ListNode start = new ListNode(0);
            start.next = head;
            ListNode pre = start;
            while (pre.next != null) {
                ListNode cur = pre.next;
                while (cur.next != null && cur.next.val == cur.val) cur = cur.next;
                if (cur != pre.next) pre.next = cur.next; // need to delete nodes
                else pre = pre.next;
            }
            return start.next;
        }

    }

    public static class UnitTest {

    }
}
