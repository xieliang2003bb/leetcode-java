package binary_tree_upside_down;

import common.TreeNode;

/**
 * Created by lxie on 2/1/18.
 */
public class UpsideDownBinaryTree {

    public class Solution {
        TreeNode upsideDownBinaryTree(TreeNode root) {
            if (root == null || root.left == null) return root;
            TreeNode l = root.left, r = root.right;
            TreeNode res = upsideDownBinaryTree(l);
            l.left = r;
            l.right = root;
            root.left = null;
            root.right = null;
            return res;
        }

        TreeNode upsideDownBinaryTree1(TreeNode root) {
            TreeNode cur = root, pre = null, next = null, tmp = null;
            while (cur != null) {
                next = cur.left;
                cur.left = tmp;
                tmp = cur.right;
                cur.right = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }

    }

    public static class UnitTest {


    }


}
