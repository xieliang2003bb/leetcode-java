package binary_tree_postorder_traversal;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {

    public class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) return res;
            Stack<TreeNode> s = new Stack<>();
            s.push(root);
            TreeNode head = root;
            while (!s.empty()) {
                TreeNode t = s.peek();
                if ((t.left == null && t.right == null) ||
                        t.left == head || t.right == head) {
                    res.add(t.val);
                    s.pop();
                    head = t;  // set head to t after added to res
                } else {
                    if (t.right != null) s.push(t.right);
                    if (t.left != null) s.push(t.left);
                }
            }
            return res;
        }
    }

    public static class UnitTest {

    }
}
