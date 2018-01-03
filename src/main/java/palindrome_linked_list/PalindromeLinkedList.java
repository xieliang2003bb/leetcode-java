package palindrome_linked_list;

import common.ListNode;

/**
 * Created by lxie on 1/2/18.
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode last = slow.next, pre = head;
        while (last.next != null) {
            ListNode tmp = last.next;
            last.next = tmp.next;
            tmp.next = slow.next;
            slow.next = tmp;
        }
        while (slow.next != null) {
            slow = slow.next;
            if (pre.val != slow.val) return false;
            pre = pre.next;
        }
        return true;
    }
}
