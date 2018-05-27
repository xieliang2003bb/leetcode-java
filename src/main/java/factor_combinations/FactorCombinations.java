package factor_combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxie on 5/27/18.
 */
public class FactorCombinations {

    public static class Solution {

        public List<List<Integer>> getFactors(int n) {
            List<List<Integer>> res = new ArrayList<>();
            helper(n, 2, new ArrayList<Integer>(), res);
            return res;
        }

        void helper(int n, int start, List<Integer> out, List<List<Integer>> res) {
            if (n == 1) {
                if (out.size() > 1) res.add(new ArrayList<>(out));
            } else {
                for (int i = start; i <= n; ++i) {
                    if (n % i == 0) {
                        out.add(i);
                        helper(n / i, i, out, res);
                        out.remove(out.size()-1);
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("result is " + sol.getFactors(32));
    }

}
