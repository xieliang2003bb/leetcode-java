package average_of_levels_btree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by lxie on 10/8/18.
 */
public class AvgLevelsBTree {

    public class Solution {

        List<Double> averageOfLevels(TreeNode root) {
            List<Double> res = new ArrayList<>();
            if (root == null) return res;
            Queue<TreeNode> q = new LinkedList<>(); q.add(root);
            while (!q.isEmpty()) {
                int n = q.size();
                double sum = 0;
                for (int i = 0; i < n; ++i) {
                    TreeNode t = q.peek(); q.poll();
                    sum += t.val;
                    if (t.left != null) q.add(t.left);
                    if (t.right != null) q.add(t.right);
                }
                res.add(sum / n);
            }
            return res;
        }

    }

    public class UnitTest {


    }

}
