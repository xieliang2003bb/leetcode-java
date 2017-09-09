package sum_of_left_leaves;

/**
 * Created by lxie on 9/8/17.
 */
public class SumOfLeftLeaves {

    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
    }

    class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            if(root == null) return 0;
            if(root.left != null && root.left.left == null && root.left.right == null){
                return root.left.val + sumOfLeftLeaves(root.right);
            }
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);

        }
    }

    public static void main(String[] args) {
        System.out.println("this is for test");
    }

}
