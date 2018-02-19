package invert_binary_tree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lxie on 2/18/18.
 */
public class InvertBinaryTree {

    public class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return null;
            TreeNode tmp = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(tmp);
            return root;
        }

        public TreeNode invertTree1(TreeNode root) {
            if (root == null) return null;
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                TreeNode  node = q.peek();
                q.remove();
                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            return root;
        }

    }

    public static class UnitTest {

    }

}
