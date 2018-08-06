package recover_binary_search_tree;

import common.TreeNode;

public class RecoverBinarySearchTree {

    public class Solution {    // O(1) space
        public void recoverTree(TreeNode root) {
            TreeNode first = null, second = null, parent = null;
            TreeNode cur, pre;
            cur = root;
            while (cur != null) {
                if (cur.left == null) {
                    if (parent != null && parent.val > cur.val) {
                        if (first == null) first = parent;
                        second = cur;
                    }
                    parent = cur;
                    cur = cur.right;
                } else {
                    pre = cur.left;
                    while (pre.right != null && pre.right != cur) pre = pre.right;
                    if (pre.right == null) {
                        pre.right = cur;
                        cur = cur.left;
                    } else {
                        pre.right = null;
                        if (parent.val > cur.val) {
                            if (first == null) first = parent;
                            second = cur;
                        }
                        parent = cur;
                        cur = cur.right;
                    }
                }
            }
            if (first != null && second != null) swap(first, second);
        }


        private void swap(TreeNode first, TreeNode second) {
            int temp = second.val;
            second.val = first.val;
            first.val = temp;
        }
    }

    public static class UnitTest {
    }
}
