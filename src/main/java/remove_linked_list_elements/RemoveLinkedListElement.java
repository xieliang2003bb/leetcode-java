package remove_linked_list_elements;

import common.ListNode;

/**
 * Created by lxie on 2/5/18.
 */
public class RemoveLinkedListElement {

    public class Solution {
        ListNode removeElements(ListNode head, int val) {
            ListNode dummy = new ListNode(-1);
            ListNode pre = dummy;
            dummy.next = head;
            while (pre.next != null) {
                if (pre.next.val == val) {
                    ListNode t = pre.next;
                    pre.next = t.next;
                    t.next = null;
                } else {
                    pre = pre.next;
                }
            }
            return dummy.next;
        }
    }

    public static class UnitTest {
        
    }

}
