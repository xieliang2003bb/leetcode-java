package longest_increasing_path_in_matrix;

/**
 * Created by lxie on 1/23/18.
 */
public class LongestIncreasingPathMatrix {

    public class Solution {

        public final int[][] dirs = new int[][] {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};


        public int longestIncreasingPath(int[][] matrix) {
                if (matrix.length == 0 || matrix[0].length == 0) return 0;
                int res = 1, m = matrix.length, n = matrix[0].length;
                int[][] dp = new int[m][n];

                for (int i = 0; i < m; ++i) {
                    for (int j = 0; j < n; ++j) {
                        res = Integer.max(res, dfs(matrix, dp, i, j));
                    }
                }
                return res;
        }


        private int dfs(int[][] matrix, int[][] dp, int i, int j) {
            if (dp[i][j] != 0) return dp[i][j];
            int mx = 1, m = matrix.length, n = matrix[0].length;
            for (int[] a : dirs) {
                int x = i + a[0], y = j + a[1];
                if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;
                int len = 1 + dfs(matrix, dp, x, y);
                mx = Integer.max(mx, len);
            }
            dp[i][j] = mx;
            return mx;
        }

    }

    public static class UnitTest {



    }
}
