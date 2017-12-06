package house_robber_III;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lxie on 12/5/17.
 */
public class HouseRobberIII {

    public class Solution {
        public int rob(TreeNode root) {
            Map<TreeNode, Integer> m = new HashMap<TreeNode, Integer>();
            return dfs(root, m);
        }

        int dfs(TreeNode root, Map<TreeNode, Integer> m) {
            if (root == null) return 0;
            if (m.containsKey(root)) return m.get(root);
            int val = 0;
            if (root.left != null) {
                val += dfs(root.left.left, m) + dfs(root.left.right, m);
            }
            if (root.right != null) {
                val += dfs(root.right.left, m) + dfs(root.right.right, m);
            }
            val = Integer.max(val + root.val, dfs(root.left, m) + dfs(root.right, m));
            m.put(root, val);
            return val;
        }

    }

    public static class UnitTest {

    }
}
