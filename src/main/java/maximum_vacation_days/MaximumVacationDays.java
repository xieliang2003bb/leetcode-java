package maximum_vacation_days;

/**
 * Created by lxie on 8/20/18.
 */
public class MaximumVacationDays {

    public class Solution {

        public int maxVacationDays(int[][] flights, int[][] days) {
            int n = flights.length, k = days[0].length, res = 0;
            int[][] dp = new int[n][k];
            for (int j = k - 1; j >= 0; --j) {
                for (int i = 0; i < n; ++i) {
                    dp[i][j] = days[i][j];
                    for (int p = 0; p < n; ++p) {
                        if ((i == p || (flights[i][p]) != 0 && j < k - 1)) {
                            dp[i][j] = Math.max(dp[i][j], dp[p][j + 1] + days[i][j]);
                        }
                        if (j == 0 && (i == 0 || flights[0][i] != 0))
                            res = Math.max(res, dp[i][0]);
                    }
                }
            }
            return res;
        }
        
    }

    public class UnitTest {


    }
}
