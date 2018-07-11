package min_distance_between_bst_nodes;

import common.TreeNode;

/**
 * Created by lxie on 7/11/18.
 */
public class MinDistanceBSTNodes {

    public class Solution {

        public int minDiffInBST(TreeNode root) {
            int[] res = {Integer.MAX_VALUE};
            int[] pre = {-1};
            helper(root, pre, res);
            return res[0];
        }

        private void helper(TreeNode node, int[] pre, int[] res) {
            if (node == null) return;
            helper(node.left, pre, res);
            if (pre[0] != -1) res[0] = Math.min(res[0], node.val - pre[0]);
            pre[0] = node.val;
            helper(node.right, pre, res);
        }
    }

    public class UnitTest {

    }

}
