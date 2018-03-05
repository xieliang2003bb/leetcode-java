package kth_smallest_in_bst;

import common.TreeNode;

import java.util.Stack;

/**
 * Created by lxie on 3/2/18.
 */
public class KthSmallestInBst {

    public class Solution  {
        public int kthSmallest(TreeNode root, int k) {
            int[] c = {k};
            return kthSmallestDFS(root, c);
        }

        private int kthSmallestDFS(TreeNode root, int[] c) {
            if (root == null) return -1;
            int val = kthSmallestDFS(root.left, c);
            if (c[0] == 0) return val;
            if (--c[0] == 0) return root.val;
            return kthSmallestDFS(root.right, c);
        }

        // non-recursive
        public int kthSmallest2(TreeNode root, int k) {
            int cnt = 0;
            Stack<TreeNode> s = new Stack<>();
            TreeNode p = root;
            while (p != null || !s.empty()) {
                while (p != null) {
                    s.push(p);
                    p = p.left;
                }
                p = s.peek(); s.pop();
                ++cnt;
                if (cnt == k) return p.val;
                p = p.right;
            }
            return 0;
        }
    }

    public static class UnitTest {

    }

}
