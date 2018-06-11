package closest_bst_value;

import common.TreeNode;

/**
 * Created by lxie on 6/11/18.
 */
public class ClosestBSTValue {

    public class Solution {

        public int closestValue(TreeNode root, double target) {
            int res = root.val;
            while (root != null) {
                if (Math.abs(res - target) >= Math.abs(root.val - target)) {
                    res = root.val;
                }
                root = target < root.val ? root.left : root.right;
            }
            return res;
        }

        int closestValueRecursive(TreeNode root, double target) {
            int a = root.val;
            TreeNode t = target < a ? root.left : root.right;
            if (t == null) return a;
            int b = closestValue(t, target);
            return Math.abs(a - target) < Math.abs(b - target) ? a : b;
        }
    }

    public class UnitTest {

    }

}
