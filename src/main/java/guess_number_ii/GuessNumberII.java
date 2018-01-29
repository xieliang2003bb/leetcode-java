package guess_number_ii;

/**
 * Created by lxie on 1/28/18.
 */
public class GuessNumberII {

    public class Solution {
        public int getMoneyAmount(int n) {
            int[][] dp = new int[n+1][n+1];
            for (int i = 2; i <= n; ++i) {
                for (int j = i - 1; j > 0; --j) {
                    int global_min = Integer.MAX_VALUE;
                    for (int k = j + 1; k < i; ++k) {
                        int local_max = k + Integer.max(dp[j][k - 1], dp[k + 1][i]);
                        global_min = Integer.min(global_min, local_max);
                    }
                    dp[j][i] = j + 1 == i ? j : global_min;
                }
            }
            return dp[1][n];
        }

    }

    public static class UnitTest {

    }


}
