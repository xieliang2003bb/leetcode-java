package find_duplicate_subtrees;

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lxie on 8/25/18.
 */
public class FindDuplicateSubtrees {

    public class Solution {
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            List<TreeNode> res = new ArrayList<>();
            Map<String, Integer> m = new HashMap<>();
            helper(root, m, res);
            return res;
        }

        private String helper(TreeNode node, Map<String, Integer> m, List<TreeNode> res) {
            if (node == null) return "#";
            String str = Integer.toString(node.val) + "," + helper(node.left, m, res) + "," +
                    helper(node.right, m, res);
            if (m.containsKey(str) && m.get(str) == 1) res.add(node);
            if (!m.containsKey(str)) m.put(str, 1);
            else m.put(str, m.get(str)+1);
            return str;
        }
    }

    public class UnitTest {

    }

}
