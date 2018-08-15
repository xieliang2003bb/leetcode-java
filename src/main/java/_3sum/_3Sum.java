package _3sum;

import java.util.*;

public class _3Sum {

    public class Solution {

        public List<List<Integer>> threeSum(int[] nums) {
            Set<List<Integer>> res = new HashSet<>();
            Arrays.sort(nums);
            for (int k = 0; k < nums.length; ++k) {
                if (nums[k] > 0) break;
                int target = 0 - nums[k];
                int i = k + 1, j = nums.length - 1;
                while (i < j) {
                    if (nums[i] + nums[j] == target) {
                        res.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
                        while (i < j && nums[i] == nums[i + 1]) ++i;
                        while (i < j && nums[j] == nums[j - 1]) --j;
                        ++i;
                        --j;
                    } else if (nums[i] + nums[j] < target) ++i;
                    else --j;
                }
            }
            return new ArrayList<>(res);
        }
    }

        public static class UnitTest {

    }
}
