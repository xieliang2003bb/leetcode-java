package reverse_nodes_in_kgroup;

import common.ListNode;

public class ReverseNodesinkGroup {

    public static class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode cur = head;
            for (int i = 0; i < k; ++i) {
                if (cur == null) return head;
                cur = cur.next;
            }
            ListNode new_head = reverse(head, cur);
            head.next = reverseKGroup(cur, k);
            return new_head;
        }

        public ListNode reverse(ListNode head, ListNode tail) {
            ListNode pre = tail;
            while (head != tail) {
                ListNode t = head.next;
                head.next = pre;
                pre = head;
                head = t;
            }
            return pre;
        }
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode head = test.reverseKGroup(node1, 3);
        while (head != null) {
            System.out.println(head.val + " ");
            head = head.next;
        }
    }
}
