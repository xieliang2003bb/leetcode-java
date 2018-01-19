package binary_tree_preorder_traversal;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

    public class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) return res;
            Stack<TreeNode> s = new Stack<>();
            s.push(root);
            while (!s.empty()) {
                TreeNode t = s.peek(); s.pop();
                res.add(t.val);
                if (t.right != null) s.push(t.right);
                if (t.left != null) s.push(t.left);
            }
            return res;
        }
    }

    public static class UnitTest {

    }
}
