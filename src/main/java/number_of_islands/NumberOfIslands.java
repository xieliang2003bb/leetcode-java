package number_of_islands;

/**
 * Created by lxie on 1/23/18.
 */
public class NumberOfIslands {

    public class Solution {
        public int numIslands(char[][] grid) {
            if (grid.length == 0 || grid[0].length == 0) return 0;
            int m = grid.length, n = grid[0].length, res = 0;
            boolean[][] visited = new boolean[m][n];

            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == '1' && !visited[i][j]) {
                        numIslandsDFS(grid, visited, i, j);
                        ++res;
                    }
                }
            }
            return res;
        }

        public void numIslandsDFS(char[][] grid, boolean[][] visited, int x, int y) {
            if (x < 0 || x >= grid.length) return;
            if (y < 0 || y >= grid[0].length) return;
            if (grid[x][y] != '1' || visited[x][y]) return;
            visited[x][y] = true;
            numIslandsDFS(grid, visited, x - 1, y);
            numIslandsDFS(grid, visited, x + 1, y);
            numIslandsDFS(grid, visited, x, y - 1);
            numIslandsDFS(grid, visited, x, y + 1);
        }

    }

    public static class UnitTest {




    }

}
