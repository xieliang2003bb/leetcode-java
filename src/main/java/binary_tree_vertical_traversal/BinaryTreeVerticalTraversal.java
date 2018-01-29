package binary_tree_vertical_traversal;

import common.TreeNode;

import java.util.*;

/**
 * Created by lxie on 1/29/18.
 */
public class BinaryTreeVerticalTraversal {

    public class Solution {

        public List<List<Integer>> verticalOrder(TreeNode root) {
            List<List<Integer>> results = new ArrayList<>();
            if (root == null) {
                return results;
            }
            Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
            Queue<Integer> qCol = new LinkedList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            qCol.offer(0);

            while(!queue.isEmpty()) {
                TreeNode curr = queue.poll();
                int col = qCol.poll();
                if(!map.containsKey(col)) {
                    map.put(col, new ArrayList<Integer>(Arrays.asList(curr.val)));
                } else {
                    map.get(col).add(curr.val);
                }
                if(curr.left != null) {
                    queue.offer(curr.left);
                    qCol.offer(col - 1);
                }
                if(curr.right != null) {
                    queue.offer(curr.right);
                    qCol.offer(col + 1);
                }
            }
            for(int n : map.keySet()) {
                results.add(map.get(n));
            }
            return results;
        }

    }

    public static class UnitTest {


    }


}
