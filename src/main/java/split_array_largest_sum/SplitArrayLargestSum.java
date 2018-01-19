package split_array_largest_sum;

/**
 * Created by lxie on 1/19/18.
 */
public class SplitArrayLargestSum {

    public class Solution {
        public int splitArray(int[] nums, int m) {
            int n = nums.length;
            int[] sums = new int[n+1];
            int[][] dp = new int[m+1][n+1];
            for (int i=0; i<=m; ++i)
                for(int j=0; j<=n; ++j)
                    dp[i][j] = Integer.MAX_VALUE;

            dp[0][0] = 0;
            for (int i = 1; i <= n; ++i) {
                sums[i] = sums[i - 1] + nums[i - 1];
            }
            for (int i = 1; i <= m; ++i) {
                for (int j = 1; j <= n; ++j) {
                    for (int k = i - 1; k < j; ++k) {
                        int val = Integer.max(dp[i - 1][k], sums[j] - sums[k]);
                        dp[i][j] = Integer.min(dp[i][j], val);
                    }
                }
            }
            return dp[m][n];

        }
    }

    public static class UnitTest {

    }


}
