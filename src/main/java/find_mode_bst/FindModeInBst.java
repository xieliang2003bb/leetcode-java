package find_mode_bst;

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lxie on 7/18/18.
 */
public class FindModeInBst {

    public class Solution {

        public List<Integer> findMode(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            int[] mx = {0};
            Map<Integer, Integer> m = new HashMap<>();
            inorder(root, m, mx);
            for (Map.Entry<Integer, Integer> a : m.entrySet()) {
                if (a.getValue().equals(mx)) {
                    res.add(a.getKey());
                }
            }
            return res;
        }

        private void inorder(TreeNode node, Map<Integer, Integer> m, int[] mx) {
            if (node == null) return;
            inorder(node.left, m, mx);
            if (!m.containsKey(node.val)) {
                m.put(node.val, 1);
            } else {
                m.put(node.val, m.get(node.val)+1);
            }
            mx[0] = Math.max(mx[0], m.get(node.val));
            inorder(node.right, m, mx);
        }


    }

    public class UnitTest {


    }

}
