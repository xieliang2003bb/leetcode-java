package house_robber;

public class HouseRobber {

    public class Solution {
        public int rob(int[] nums) {
            if (nums.length <= 1) return nums.length == 0 ? 0 : nums[0];
            int[] dp = new int[nums.length];
            dp[0] = nums[0]; dp[1] = Integer.max(nums[0], nums[1]);
            for (int i = 2; i < nums.length; ++i) {
                dp[i] = Integer.max(nums[i] + dp[i - 2], dp[i - 1]);
            }
            return dp[nums.length - 1];
        }
    }

    public static class UnitTest {

    }
}

