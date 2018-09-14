package longest_line_consecutive_one_in_matrix;

import static java.lang.Math.max;

/**
 * Created by lxie on 9/14/18.
 */
public class LongestLineConsecutiveOneInMatrix {

    public class Solution {

        public int longestLine(int[][] M) {
            if (M.length == 0 || M[0].length == 0) return 0;
            int m = M.length, n = M[0].length, res = 0;
            int[][][] dp = new int[m][n][4];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (M[i][j] == 0) continue;
                    for (int k = 0; k < 4; ++k) dp[i][j][k] = 1;
                    if (j > 0) dp[i][j][0] += dp[i][j - 1][0]; // horizonal
                    if (i > 0) dp[i][j][1] += dp[i - 1][j][1]; // vertical
                    if (i > 0 && j < n - 1) dp[i][j][2] += dp[i - 1][j + 1][2]; // diagonal
                    if (i > 0 && j > 0) dp[i][j][3] += dp[i - 1][j - 1][3]; // anti-diagonal
                    res = max(res, max(dp[i][j][0], dp[i][j][1]));
                    res = max(res, max(dp[i][j][2], dp[i][j][3]));
                }
            }
            return res;
        }
    }

    public class UnitTest {


    }

}
