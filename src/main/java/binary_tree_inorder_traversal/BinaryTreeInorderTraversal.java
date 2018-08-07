package binary_tree_inorder_traversal;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

    public class Solution {
        public ArrayList<Integer> inorderTraversal(TreeNode root) {
            ArrayList<Integer> ans = new ArrayList<Integer>();
            Stack<TreeNode> s = new Stack<>();
            TreeNode p = root;
            while (p != null || !s.empty()) {
                while (p != null) {
                    s.push(p);
                    p = p.left;
                }
                p = s.peek();
                s.pop();
                ans.add(p.val);
                p = p.right;
            }
            return ans;

        }
    }

    public static class UnitTest {

    }
}
