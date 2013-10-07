package binary_tree_level_order_traversal;

import java.util.ArrayList;

import common.TreeNode;

public class BinaryTreeLevelOrderTraversal {

    public class Solution {
        public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
            ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
            if (root == null) {
                return ans;
            }
            ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
            int start = 0;
            queue.add(root);
            while (start != queue.size()) {
                ArrayList<Integer> level = new ArrayList<Integer>();
                int len = queue.size();
                for (; start < len; start++) {
                    TreeNode node = queue.get(start);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    level.add(node.val);
                }
                ans.add(level);
            }
            return ans;
        }
    }

    public static class UnitTest {

    }
}
