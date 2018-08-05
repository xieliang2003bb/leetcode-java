package construct_binary_tree_from_preorder_and_inorder_traversal;

import common.TreeNode;

import java.util.List;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

    public class Solution {
        TreeNode buildTree(List<Integer> preorder, List<Integer> inorder) {
            return buildTree(preorder, 0, preorder.size() - 1, inorder, 0, inorder.size() - 1);
        }
        TreeNode buildTree(List<Integer> preorder, int pLeft, int pRight,
                           List<Integer> inorder, int iLeft, int iRight) {
            if (pLeft > pRight || iLeft > iRight) return null;
            int i = 0;
            for (i = iLeft; i <= iRight; ++i) {
                if (preorder.get(pLeft) == inorder.get(i)) break;
            }
            TreeNode cur = new TreeNode(preorder.get(pLeft));
            cur.left = buildTree(preorder, pLeft + 1, pLeft + i - iLeft, inorder, iLeft, i - 1);
            cur.right = buildTree(preorder, pLeft + i - iLeft + 1, pRight, inorder, i + 1, iRight);
            return cur;
        }

    }

    public static class UnitTest {

    }
}
