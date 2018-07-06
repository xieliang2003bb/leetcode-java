package island_perimeter;

/**
 * Created by lxie on 7/6/18.
 */
public class IslandPerimeter {

    public class Solution {

        public int islandPerimeter(int[][] grid) {
            if (grid.length == 0 || grid[0].length == 0) return 0;
            int m = grid.length, n = grid[0].length, res = 0;
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == 0) continue;
                    if (j == 0 || grid[i][j - 1] == 0) ++res;
                    if (i == 0 || grid[i - 1][j] == 0) ++res;
                    if (j == n - 1 || grid[i][j + 1] == 0) ++res;
                    if (i == m - 1 || grid[i + 1][j] == 0) ++res;
                }
            }
            return res;
        }
    }

    public class UnitTest {


    }

}
