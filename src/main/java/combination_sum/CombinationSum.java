package combination_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public class Solution {
        public List<List<Integer>> combinationSum(int[] num, int target) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> out = new ArrayList<>();
            Arrays.sort(num);
            combinationSum2DFS(num, target, 0, out, res);
            return res;
        }

        private void combinationSum2DFS(int[] num, int target, int start, List<Integer> out, List<List<Integer>> res) {
            if (target < 0) return;
            else if (target == 0) res.add(new ArrayList<>(out));
            else {
                for (int i = start; i < num.length; ++i) {
                    if (i > start && num[i] == num[i - 1]) continue;
                    out.add(num[i]);
                    combinationSum2DFS(num, target - num[i], i, out, res); // allows duplicate
                    out.remove(out.size()-1);
                }
            }
        }
    }

    public static class UnitTest {

    }
}
