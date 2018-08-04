package populating_next_right_pointers_in_each_node_ii;

import common.TreeLinkNode;

public class PopulatingNextRightPointersinEachNodeII {

    public class Solution {   // const space
        public void connect(TreeLinkNode root) {
            TreeLinkNode dummy = new TreeLinkNode(0), t = dummy;
            while (root != null) {
                if (root.left != null) {
                    t.next = root.left;
                    t = t.next;
                }
                if (root.right != null) {
                    t.next = root.right;
                    t = t.next;
                }
                root = root.next;
                if (root == null) {
                    t = dummy;
                    root = dummy.next;
                    dummy.next = null;
                }
            }
        }

    }

    public static class UnitTest {

    }
}
