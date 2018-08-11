package rotate_list;

import common.ListNode;

public class RotateList {

    public class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null) return null;
            int n = 0;
            ListNode cur = head;
            while (cur != null) {
                ++n;
                cur = cur.next;
            }
            k %= n;
            ListNode fast = head, slow = head;
            for (int i = 0; i < k; ++i) {
                if (fast != null) fast = fast.next;
            }
            if (fast == null) return head;
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            fast.next = head;
            fast = slow.next;
            slow.next = null;
            return fast;
        }


        public class UnitTest {

        }
    }
}
