package binary_tree_paths;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxie on 6/3/18.
 */
public class BinaryTreePaths {

    public static class Solution {

        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList<>();
            if (root != null) dfs(root, "", res);
            return res;
        }

            public void dfs(TreeNode root, String out, List<String> res) {
            out += Integer.toString(root.val);
            if (root.left == null && root.right == null) res.add(out);
            else {
                if (root.left != null) dfs(root.left, out + "->", res);
                if (root.right != null) dfs(root.right, out + "->", res);
            }  // out is not string &
        }





    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2); root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        List<String> res = sol.binaryTreePaths(root);
        System.out.println("result is " + res);
    }

}
