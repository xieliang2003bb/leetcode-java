package reverse_linked_list_ii;

import common.ListNode;

public class ReverseLinkedListII {

    public class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode prefix = null;
            int count = n - m + 1;
            m--;
            while (m > 0) {
                prefix = prefix == null ? head : prefix.next;
                m--;
            }
            ListNode pre = null;
            ListNode p = prefix == null ? head : prefix.next;
            ListNode reversedTail = p;
            while (count > 0) {
                ListNode temp = p.next;
                if (pre != null) {
                    p.next = pre;
                }
                pre = p;
                p = temp;
                count--;
            }
            if (prefix == null) {
                head = pre;
            } else {
                prefix.next = pre;
            }
            if (reversedTail != null) {
                reversedTail.next = p;
            }
            return head;
        }
    }

    public static class UnitTest {

    }
}
