package find_mode_in_bst;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by lxie on 9/1/18.
 */
public class FindModeInBST {

    public class Solution {

        public int[] findMode(TreeNode root) {
            if (root == null) return new int[0];
            List<Integer> res = new ArrayList<>();
            TreeNode p = root, pre = null;
            Stack<TreeNode> s = new Stack<>();
            int mx = 0, cnt = 1;;
            while (!s.isEmpty() || p != null) {
                while (p != null) {
                    s.push(p);
                    p = p.left;
                }
                p = s.peek(); s.pop();
                if (pre != null) {
                    cnt = (p.val == pre.val) ? cnt + 1 : 1;
                }
                if (cnt >= mx) {
                    if (cnt > mx) res.clear();
                    res.add(p.val);
                    mx = cnt;
                }
                pre = p;
                p = p.right;
            }
            return res.stream().mapToInt(i->i).toArray();
        }

    }

    public class UnitTest {


    }

}
