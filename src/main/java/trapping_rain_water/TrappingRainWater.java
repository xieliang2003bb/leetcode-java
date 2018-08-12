package trapping_rain_water;

public class TrappingRainWater {

    public class Solution {
        public int trap(int[] height) {
            int res = 0, mx = 0, n = height.length;
            int[] dp = new int[n];
            for (int i = 0; i < n; ++i) {
                dp[i] = mx;
                mx = Math.max(mx, height[i]);
            }
            mx = 0;
            for (int i = n - 1; i >= 0; --i) {
                dp[i] = Math.min(dp[i], mx);
                mx = Math.max(mx, height[i]);
                if (dp[i] > height[i]) res += dp[i] - height[i];
            }
            return res;

        }
    }

    public static class UnitTest {

    }
}
