package linked_list_random_node;

import common.ListNode;

import java.util.Random;

/**
 * Created by lxie on 9/2/18.
 */
public class LinkedListRandomNode {

    public class Solution {

        private ListNode head = null;

        public Solution(ListNode head) {
            this.head = head;
        }

        public int getRandom() {
            int res = head.val, i = 2;
            ListNode cur = head.next;
            Random generator = new Random();
            while (cur != null) {
                int j = generator.nextInt(i);  // reservior sampling size = 1
                if (j == 0) res = cur.val;
                ++i;
                cur = cur.next;
            }
            return res;
        }
    }

    public class UnitTest {

    }
}
