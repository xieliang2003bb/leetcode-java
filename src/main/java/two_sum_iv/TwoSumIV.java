package two_sum_iv;

import common.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lxie on 10/9/18.
 */
public class TwoSumIV {

    public class Solution {

        public boolean findTarget(TreeNode root, int k) {
            if (root == null) return false;
            Set<Integer> s = new HashSet<>();
            return helper(root, k, s);
        }

        private boolean helper(TreeNode node, int k, Set<Integer> s) {
            if (node == null) return false;
            if (s.contains(k - node.val)) return true;
            s.add(node.val);
            return helper(node.left, k, s) || helper(node.right, k, s);
        }

    }

    public class UnitTest {


    }

}
