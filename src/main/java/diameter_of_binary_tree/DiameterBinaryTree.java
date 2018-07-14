package diameter_of_binary_tree;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lxie on 7/13/18.
 */
public class DiameterBinaryTree {

    public class Solution {
        private Map<TreeNode, Integer> m = new HashMap<>();

        public int diameterOfBinaryTree(TreeNode root) {
            int[] res = {0};
            maxDepth(root, res);
            return res[0];
        }
        int maxDepth(TreeNode node, int[] res) {
            if (node == null) return 0;
            if (m.containsKey(node)) return m.get(node);
            int left = maxDepth(node.left, res);
            int right = maxDepth(node.right, res);
            res[0] = Math.max(res[0], left + right);
            int ret = Math.max(left, right) + 1;
            m.put(node, ret);
            return ret;
        }
    }

    public class UnitTest {


    }
}
