package largest_bst_subtree;

import common.TreeNode;

/**
 * Created by lxie on 11/26/17.
 */
public class LargestBSTSubtree {
    public static class Solution {
        public int largest(TreeNode root) {
            int[] params = new int[3];
            params[0] = Integer.MIN_VALUE; params[1] = Integer.MAX_VALUE; params[2] = 0;  // mn, mx, res
            boolean d = isValidBST(root, params);
            return params[2];
        }

        boolean isValidBST(TreeNode root, int[] params) {
            if (root == null) return true;

            int[] leftParams = new int[3];
            leftParams[0] = Integer.MIN_VALUE; leftParams[1] = Integer.MAX_VALUE; leftParams[2] = 0;
            boolean left = isValidBST(root.left, leftParams);
            int[] rightParams = new int[3];
            rightParams[0] = Integer.MIN_VALUE; rightParams[1] = Integer.MAX_VALUE; rightParams[2] = 0;
            boolean right = isValidBST(root.right, rightParams);

            if (left && right) {
                if ((root.left == null || root.val >= leftParams[1]) && (root.right == null || root.val <= rightParams[0])) {
                    params[2] = leftParams[2] + rightParams[2] + 1;
                    params[0] = root.left != null ? leftParams[0] : root.val; // update ranges
                    params[1] = root.right != null ? rightParams[1] : root.val;
                    return true;
                }
            }
            params[2] = Integer.max(leftParams[2], rightParams[2]);
            return false;
        }


    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5); root.right = new TreeNode(15);
        root.left.left = new TreeNode(1); root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(7);

        int res = sol.largest(root);

        System.out.println("result is " + res);
    }
}
