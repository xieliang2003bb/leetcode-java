package verify_preorder_sequence_bst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by lxie on 5/28/18.
 */
public class PreorderSeqBst {

    public static class Solution {

        public boolean verifyPreorder(List<Integer> preorder) {
            int low = Integer.MIN_VALUE;
            Stack<Integer> s = new Stack<>();
            for (int a : preorder) {
                if (a < low) return false;
                while (!s.empty() && a > s.peek()) {
                    low = s.peek(); s.pop();
                }
                s.push(a);
            }
            return true;
        }


        public boolean verifyPreorderRecursive(List<Integer> preorder) {
            return helper(preorder, 0, preorder.size() - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        boolean helper(List<Integer> preorder, int start, int end, int lower, int upper) {
            if (start > end) return true;
            int val = preorder.get(start), i = 0;
            if (val <= lower || val >= upper) return false;
            for (i = start + 1; i <= end; ++i) {
                if (preorder.get(i) >= val) break;
            }
            return helper(preorder, start + 1, i - 1, lower, val) && helper(preorder, i, end, val, upper);
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        boolean res = sol.verifyPreorderRecursive(new ArrayList<Integer>(Arrays.asList(5, 2, 1, 3, 6, 8, 7)));
        System.out.println("result is " + res);
    }


}
