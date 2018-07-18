package longest_univalue_path;

import common.TreeNode;

/**
 * Created by lxie on 7/18/18.
 */
public class LongestUnivaluePath {

    public class Solution {

        public int longestUnivaluePath(TreeNode root) {
            if (root == null) return 0;
            int sub = Math.max(longestUnivaluePath(root.left), longestUnivaluePath(root.right));
            return Math.max(sub, helper(root.left, root.val) + helper(root.right, root.val));
        }

        private int helper(TreeNode node, int parent) {
            if (node == null || node.val != parent) return 0;
            return 1 + Math.max(helper(node.left, node.val), helper(node.right, node.val));
        }
    }

    public class UnitTest {



    }
}
