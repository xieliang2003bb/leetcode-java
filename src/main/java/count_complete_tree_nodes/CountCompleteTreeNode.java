package count_complete_tree_nodes;

import common.TreeNode;

/**
 * Created by lxie on 2/14/18.
 */
public class CountCompleteTreeNode {

    public class Solution {

        public int countNodes(TreeNode root) {
            int hLeft = leftHeight(root);
            int hRight = rightHeight(root);
            if (hLeft == hRight) return (int) Math.pow(2, hLeft) - 1;
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
        int leftHeight(TreeNode root) {  // height of left-most
            if (root == null) return 0;
            return 1 + leftHeight(root.left);
        }
        int rightHeight(TreeNode root) { // height of righ-most
            if (root == null) return 0;
            return 1 + rightHeight(root.right);
        }
        
    }

    public static class UnitTest {


    }


}
