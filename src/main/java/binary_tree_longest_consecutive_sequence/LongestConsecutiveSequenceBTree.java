package binary_tree_longest_consecutive_sequence;

import common.TreeNode;

import static java.lang.Math.max;

/**
 * Created by lxie on 6/21/18.
 */
public class LongestConsecutiveSequenceBTree {

    public static class Solution {

        public int longestConsecutive(TreeNode root) {
            if (root == null) return 0;
            int[] res = {0};
            dfs(root, root.val - 1, 0, res);
            return res[0];
        }

        private void dfs(TreeNode root, int v, int out, int[] res) {
            if (root == null) return;
            if (root.val == v + 1) ++out;
            else out = 1;
            res[0] = max(res[0], out);
            dfs(root.left, root.val, out, res);
            dfs(root.right, root.val, out, res);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);
        int res = sol.longestConsecutive(root);
        System.out.println("result is " + res);
    }


}
