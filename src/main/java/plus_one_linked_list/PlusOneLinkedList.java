package plus_one_linked_list;

/**
 * Created by lxie on 10/1/17.
 */
public class PlusOneLinkedList {

    /**
     * Definition for singly-linked list.
     **/
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class Solution {
        public ListNode PlusOneLinkedList(ListNode head) {
            if (head == null) return head;
            int carry = helper(head);
            if (carry == 1) {
                ListNode res = new ListNode(1);
                res.next = head;
                return res;
            }
            return head;
        }

        int helper(ListNode node) {
            if (node == null) return 1;
            int carry = helper(node.next);
            int sum = node.val + carry;
            node.val = sum % 10;
            return sum/10;
        }

    }
    
    public static class UnitTest {

    }


}
