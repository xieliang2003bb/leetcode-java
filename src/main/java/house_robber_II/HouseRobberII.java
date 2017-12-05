package house_robber_II;

/**
 * Created by lxie on 12/4/17.
 */
public class HouseRobberII {

    public class Solution {
        public int rob(int[] nums) {
            if (nums.length <= 1) return nums.length == 0 ? 0 : nums[0];

            return Integer.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
        }

        int rob(int[]nums, int left, int right) {
            if (right == left) return nums[left];
            int[] dp = new int[right + 1];
            dp[left] = nums[left];
            dp[left + 1] = Integer.max(nums[left], nums[left + 1]);
            for (int i = left + 2; i <= right; ++i) {
                dp[i] = Integer.max(nums[i] + dp[i - 2], dp[i - 1]);
            }
            return dp[right];
        }

    }

    public static class UnitTest {

    }
}
