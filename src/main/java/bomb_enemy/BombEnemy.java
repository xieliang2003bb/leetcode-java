package bomb_enemy;

/**
 * Created by lxie on 12/7/17.
 */
public class BombEnemy {

    public class Solution {
        public int maxKilledEnemies(char[][] grid) {
            if (grid == null || grid[0] == null) return 0;
            int m = grid.length, n = grid[0].length, res = 0, rowCnt = 0;
            int[] colCnt = new int[n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (j == 0 || grid[i][j - 1] == 'W') {
                        rowCnt = 0;
                        for (int k = j; k < n && grid[i][k] != 'W'; ++k) {
                            rowCnt += grid[i][k] == 'E' ? 1 : 0;
                        }
                    }
                    if (i == 0 || grid[i - 1][j] == 'W') {
                        colCnt[j] = 0;
                        for (int k = i; k < m && grid[k][j] != 'W'; ++k) {
                            colCnt[j] += grid[k][j] == 'E' ? 1 : 0;
                        }
                    }
                    if (grid[i][j] == '0') {
                        res = Integer.max(res, rowCnt + colCnt[j]);
                    }
                }
            }
            return res;

        }
    }

    public static class UnitTest {

    }
}
