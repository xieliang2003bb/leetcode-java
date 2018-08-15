package _3sum_closest;

import java.util.*;

public class _3SumClosest {

    public class Solution {
        public int threeSumClosest(int[] nums, int target) {
            int closest = nums[0] + nums[1] + nums[2];
            int diff = Math.abs(closest - target);
            Arrays.sort(nums);
            for (int k = 0; k < nums.length; ++k) {
                int i = k + 1, j = nums.length - 1;
                while (i < j) {
                    int sum = nums[k] + nums[i] + nums[j];
                    int newDiff = Math.abs(sum - target);
                    if (diff > newDiff) {
                        diff = newDiff;
                        closest = sum;
                    }
                    if (sum < target) ++i;
                    else --j;

                }
            }
            return closest;
        }
    }

    public static class UnitTest {

    }
}
