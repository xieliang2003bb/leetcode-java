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


    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        boolean res = sol.verifyPreorder(new ArrayList<Integer>(Arrays.asList(5, 2, 1, 3, 6, 8, 7)));
        System.out.println("result is " + res);
    }


}
