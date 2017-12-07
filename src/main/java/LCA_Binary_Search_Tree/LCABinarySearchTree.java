package lca_binary_search_tree;

import common.TreeNode;

/**
 * Created by lxie on 12/6/17.
 */
public class LCABinarySearchTree {

    public class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            while (true) {
                if (root.val > Integer.max(p.val, q.val)) root = root.left;
                else if (root.val < Integer.min(p.val, q.val)) root = root.right;
                else break;
            }
            return root;
        }
    }

    public static class UnitTest {

    }
}
