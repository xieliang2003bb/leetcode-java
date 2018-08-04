package path_sum_ii;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public class Solution {

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> out = new ArrayList<>();
            helper(root, sum, out, res);
            return res;
        }

        private void helper(TreeNode node, int sum, List<Integer> out, List<List<Integer>> res) {
            if (node == null) return;
            out.add(node.val);
            if (sum == node.val && node.left == null && node.right == null) {
                res.add(new ArrayList<>(out));  // do not use the same reference
            }
            helper(node.left, sum - node.val, out, res);
            helper(node.right, sum - node.val, out, res);
            out.remove(out.size()-1); // back-track to remove current
        }

    }

    public static class UnitTest {

    }
}
