package subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    public class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<java.util.List<Integer>> res = new ArrayList<>();
            List<Integer> out = new ArrayList<>();
            Arrays.sort(nums);
            getSubsets(nums, 0, out, res);
            return res;
        }

        private void getSubsets(int[] nums, int pos, List<Integer> out, List<List<Integer>> res) {
            res.add(new ArrayList<>(out));
            for (int i = pos; i < nums.length; ++i) {
                out.add(nums[i]);
                getSubsets(nums, i + 1, out, res);
                out.remove(out.size()-1);
            }
        }
    }

    public static class UnitTest {

    }
}
