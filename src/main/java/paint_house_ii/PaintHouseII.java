package paint_house_ii;

/**
 * Created by lxie on 6/6/18.
 */
public class PaintHouseII {

    public class Solution {

        public int minCostII(int[][] costs) {
            if (costs.length == 0 || costs[0].length == 0) return 0;
            int[][] dp = costs;
            int min1 = -1, min2 = -1;
            for (int i = 0; i < dp.length; ++i) {
                int last1 = min1, last2 = min2;
                min1 = -1; min2 = -1;
                for (int j = 0; j < dp[i].length; ++j) {
                    if (j != last1) {
                        dp[i][j] += last1 < 0 ? 0 : dp[i - 1][last1];
                    } else {
                        dp[i][j] += last2 < 0 ? 0 : dp[i - 1][last2];
                    }
                    if (min1 < 0 || dp[i][j] < dp[i][min1]) {
                        min2 = min1; min1 = j;
                    } else if (min2 < 0 || dp[i][j] < dp[i][min2]) {
                        min2 = j;
                    }
                }
            }
            return dp[dp.length-1][min1];
        }


    }

    public class UnitTest {


    }

}
