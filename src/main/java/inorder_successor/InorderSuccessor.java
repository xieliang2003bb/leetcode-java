package inorder_successor;

import common.TreeNode;

/**
 * Created by lxie on 6/16/18.
 */
public class InorderSuccessor {

    public class Solution {

        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            TreeNode res = null;
            while (root != null) {
                if (root.val > p.val) {
                    res = root;
                    root = root.left;
                } else root = root.right;
            }
            return res;
        }
    }

    public class UnitTest {

    }
}
