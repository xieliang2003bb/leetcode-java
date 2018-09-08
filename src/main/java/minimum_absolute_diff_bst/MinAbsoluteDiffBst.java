package minimum_absolute_diff_bst;

import common.TreeNode;

/**
 * Created by lxie on 9/8/18.
 */
public class MinAbsoluteDiffBst {

    public class Solution {

        public int getMinimumDifference(TreeNode root) {
            int res[] = {Integer.MAX_VALUE}, pre[] = {-1};
            inorder(root, pre, res);
            return res[0];
        }

        private void inorder(TreeNode root, int[] pre, int[] res) {
            if (root == null) return;
            inorder(root.left, pre, res);
            if (pre[0] != -1) res[0] = Math.min(res[0], root.val - pre[0]);
            pre[0] = root.val;
            inorder(root.right, pre, res);
        }

    }

    public class UnitTest {



    }
}
