package PerfectSquares;

/**
 * Created by lxie on 1/8/18.
 */
public class PerfectSquares {

    public class Solution {
        public int numSquares(int n) {
            int[] dp = new int[n+1];
            for (int i=0; i<dp.length; ++i) dp[i] = Integer.MAX_VALUE;
            dp[0] = 0;
            for (int i = 0; i <= n; ++i) {
                for (int j = 1; i + j * j <= n; ++j) {
                    dp[i + j * j] = Integer.min(dp[i + j * j], dp[i] + 1);
                }
            }
            return dp[n];
        }
    }

}
