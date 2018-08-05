package construct_binary_tree_from_inorder_and_postorder_traversal;

import common.TreeNode;

import java.util.List;

public class ConstructBinaryTreefromInorderandPostorderTraversal {

    public class Solution {
        public TreeNode buildTree(List<Integer> inorder, List<Integer> postorder) {
            return buildTree(inorder, 0, inorder.size() - 1, postorder, 0, postorder.size() - 1);
        }

        private TreeNode buildTree(List<Integer> inorder, int iLeft, int iRight,
                                   List<Integer> postorder, int pLeft, int pRight) {
            if (iLeft > iRight || pLeft > pRight) return null;
            TreeNode cur = new TreeNode(postorder.get(pRight));
            int i = 0;
            for (i = iLeft; i < inorder.size(); ++i) {
                if (inorder.get(i) == cur.val) break;
            }
            cur.left = buildTree(inorder, iLeft, i - 1, postorder, pLeft, pLeft + i - iLeft - 1);
            cur.right = buildTree(inorder, i + 1, iRight, postorder, pLeft + i - iLeft, pRight - 1);
            return cur;
        }

    }

    public static class UnitTest {

    }
}
