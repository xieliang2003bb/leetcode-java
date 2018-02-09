package combination_sum_iii;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxie on 2/8/18.
 */
public class CombinationSumIII {

    public static class Solution {
        // public List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> combinationSum3(int k, int n)  {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> out = new ArrayList<>();
            combinationSum3DFS(k, n, 1, out, res);
            return res;
        }
        void combinationSum3DFS(int k, int n, int level, List<Integer> out, List<List<Integer>> res) {
            if (n < 0  || out.size() > k) return;
            if (n == 0 && out.size() == k)
                res.add(new ArrayList(out));
            for (int i = level; i <= 9; ++i) {
                out.add(i);
                combinationSum3DFS(k, n - i, i + 1, out, res);
                out.remove(out.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> res = s.combinationSum3(3, 7);
        System.out.println(res);
    }


}
