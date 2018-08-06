package validate_binary_search_tree;

import common.TreeNode;

public class ValidateBinarySearchTree {

    public class Solution {

        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean isValidBST(TreeNode root, long mn, long mx) {
            if (root == null) return true;
            if (root.val <= mn || root.val >= mx) return false;
            return isValidBST(root.left, mn, root.val) && isValidBST(root.right, root.val, mx);
        }
    }

    public static class UnitTest {

    }
}
