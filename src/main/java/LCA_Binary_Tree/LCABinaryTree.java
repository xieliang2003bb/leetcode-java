package LCA_Binary_Tree;

import common.TreeNode;

/**
 * Created by lxie on 12/6/17.
 */
public class LCABinaryTree {

    public class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || p == root || q == root) return root;
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p , q);
            if (left != null && right != null) return root;
            return left != null ? left : right;
        }

    }

    public static class UnitTest {

    }


}
