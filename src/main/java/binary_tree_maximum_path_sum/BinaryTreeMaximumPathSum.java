package binary_tree_maximum_path_sum;

import common.TreeNode;

public class BinaryTreeMaximumPathSum {

    public class Solution {

        public int maxPathSum(TreeNode root) {
            int[] res = {Integer.MIN_VALUE};
            helper(root, res);
            return res[0];
        }

        private int helper(TreeNode node, int[] res) {
            if (node == null) return 0;
            int left = Math.max(helper(node.left, res), 0);
            int right = Math.max(helper(node.right, res), 0);
            res[0] = Math.max(res[0], left + right + node.val);
            return Math.max(left, right) + node.val;
        }

    }

    public static class UnitTest {

    }
}
