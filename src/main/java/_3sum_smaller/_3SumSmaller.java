package _3sum_smaller;

import java.util.Arrays;

/**
 * Created by lxie on 6/4/18.
 */
public class _3SumSmaller {

    public class Solution {

        int threeSumSmaller(int[] nums, int target) {
            if (nums.length < 3) return 0;
            int res = 0;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; ++i) {
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    if (nums[i] + nums[left] + nums[right] < target) {
                        res += right - left;
                        ++left;
                    } else {
                        --right;
                    }
                }
            }
            return res;
        }
    };

    public class UnitTest {

    }

}
