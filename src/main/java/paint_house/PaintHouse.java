package paint_house;

/**
 * Created by lxie on 6/3/18.
 */
public class PaintHouse {

    public static class Solution {

        int minCost(int [][] costs) {
            if (costs.length == 0 || costs[0].length == 0) return 0;
            int[][] dp = costs;
            for (int i = 1; i < dp.length; ++i) {
                for (int j = 0; j < 3; ++j) {
                    dp[i][j] += Integer.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]);
                }
            }
            int n = dp.length;
            return Integer.min(Integer.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] costs= {{1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}};
        int res = sol.minCost(costs);
        System.out.println("result is "+res);
    }
}
