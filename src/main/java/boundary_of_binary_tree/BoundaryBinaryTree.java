package boundary_of_binary_tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxie on 9/15/18.
 */
public class BoundaryBinaryTree {

    public class Solution {

        public List<Integer> boundaryOfBinaryTree(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) return res;
            helper(root.left, true, false, res);
            helper(root.right, false, true, res);
            return res;
        }
        void helper(TreeNode node, boolean leftbd, boolean rightbd, List<Integer> res) {
            if (node == null) return;
            if (node.left == null && node.right == null) {
                res.add(node.val);
                return;
            }
            if (leftbd) res.add(node.val);
            helper(node.left, leftbd && node.left != null, rightbd && node.right == null, res);
            helper(node.right, leftbd && node.left == null, rightbd && node.right != null, res);
            if (rightbd) res.add(node.val);
        }
    }

    public class UnitTest {


    }


}
