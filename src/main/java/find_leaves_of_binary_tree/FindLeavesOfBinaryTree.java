package find_leaves_of_binary_tree;

import java.util.ArrayList;

/**
 * Created by lxie on 9/9/17.
 */
public class FindLeavesOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
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
    }


}
