package count_univalue_subtrees;

import common.TreeNode;

/**
 * Created by lxie on 5/23/18.
 */
public class CountUnivalueSubtrees {

    public static class Solution  {

        public int countUnivalSubtrees (TreeNode root) {
            int[] res = new int[1];
            isUnival(root, -1, res);
            return res[0];
        }

        private boolean isUnival(TreeNode root, int val, int[] res) {
            if (root == null) return true;
            if (!isUnival(root.left, root.val, res) | !isUnival(root.right, root.val, res)) {
                return false;
            }
            ++res[0];
            return root.val == val;
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1); root.right = new TreeNode(5);
        root.left.left = new TreeNode(5); root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(5);

        int res = sol.countUnivalSubtrees(root);

        System.out.println("result is " + res);
    }


}
