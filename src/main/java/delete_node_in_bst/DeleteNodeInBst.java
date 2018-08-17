package delete_node_in_bst;

import common.TreeNode;

/**
 * Created by lxie on 8/17/18.
 */
public class DeleteNodeInBst {

    public class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) return null;
            if (root.val > key) {
                root.left = deleteNode(root.left, key);
            } else if (root.val < key) {
                root.right = deleteNode(root.right, key);
            } else {
                if (root.left == null || root.right == null) {
                    root = (root.left != null) ? root.left : root.right;
                } else {
                    TreeNode cur = root.right;
                    while (cur.left != null) cur = cur.left;
                    root.val = cur.val;
                    root.right = deleteNode(root.right, cur.val);
                }
            }
            return root;
        }
    }

    public class UnitTest {

    }

}
