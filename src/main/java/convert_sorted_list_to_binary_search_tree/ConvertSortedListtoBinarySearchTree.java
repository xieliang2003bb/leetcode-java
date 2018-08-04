package convert_sorted_list_to_binary_search_tree;

import common.ListNode;
import common.TreeNode;

public class ConvertSortedListtoBinarySearchTree {

    public class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            if (head == null) return null;
            if (head.next == null) return new TreeNode(head.val);
            ListNode slow = head;
            ListNode fast = head;
            ListNode last = slow;
            while (fast.next != null && fast.next.next != null) {
                last = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            fast = slow.next;
            last.next = null;
            TreeNode cur = new TreeNode(slow.val);
            if (head != slow) cur.left = sortedListToBST(head);
            cur.right = sortedListToBST(fast);
            return cur;
        }

    }

    public static class UnitTest {

    }
}
