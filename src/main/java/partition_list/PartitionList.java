package partition_list;

import common.ListNode;

public class PartitionList {

    public class Solution {
        ListNode partition(ListNode head, int x) {
            if (head == null) return head;
            ListNode dummy = new ListNode(-1);
            ListNode newDummy = new ListNode(-1);

            dummy.next = head;
            ListNode cur = dummy, p = newDummy;
            while (cur.next != null) {
                if (cur.next.val < x) {
                    p.next = cur.next;
                    p = p.next;
                    cur.next = cur.next.next;
                    p.next = null;
                } else {
                    cur = cur.next;
                }
            }
            p.next = dummy.next;
            return newDummy.next;
        }
    }

    public static class UnitTest {

    }
}
