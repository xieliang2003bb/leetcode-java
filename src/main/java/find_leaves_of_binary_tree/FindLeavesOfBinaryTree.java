package find_leaves_of_binary_tree;

import java.util.ArrayList;
import common.TreeNode;

/**
 * Created by lxie on 9/9/17.
 */
public class FindLeavesOfBinaryTree {

    public static class Solution {
        public ArrayList<ArrayList<Integer>> findLeaves(TreeNode root){
            ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
            helper(root, res);
            return res;

        }

        private int helper(TreeNode root, ArrayList<ArrayList<Integer>> res) {
            if(root == null) return -1;
            int depth = 1 + Math.max(helper(root.left, res), helper(root.right, res));
            if (depth >= res.size()) res.add(new ArrayList<>());
            res.get(depth).add(root.val);
            return depth;
        }

    }

    public static void main(String[] args) {
        System.out.println("this is for test");

        Solution sol = new Solution();

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5); root.right = new TreeNode(15);
        root.left.left = new TreeNode(1); root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(7);

        ArrayList<ArrayList<Integer>> result = sol.findLeaves(root);
        System.out.print(result);
    }
}
