package permutations_ii;

import java.util.*;
import java.util.stream.Collectors;

public class PermutationsII {

    public class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            Set<List<Integer>> res = new HashSet<>();
            permute(nums, 0, res);
            return new ArrayList<>(res);
        }

        private void permute(int[] nums, int start, Set<List<Integer>> res) {
            if (start >= nums.length)
                res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            for (int i = start; i < nums.length; ++i) {
                if (i != start && nums[i] == nums[start]) continue;
                swap(nums, i, start);
                permute(nums, start + 1, res);
                swap(nums, i, start);
            }
        }

        private void swap(int[] num, int i, int j) {
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }

    }

    public static class UnitTest {

    }
}
