package the_maze;

import java.util.Arrays;

/**
 * Created by lxie on 8/27/18.
 */
public class TheMaze {

    public class Solution {

        public int[][] dirs = {{0,-1},{-1,0},{0,1},{1,0}};

        boolean hasPath(int[][] maze, int[] start, int[] destination) {
            if (maze.length == 0 || maze[0].length == 0) return true;
            int m = maze.length, n = maze[0].length;
            int[][] dp = new int[m][n];
            for (int[] a : dp) Arrays.fill(a, -1);
            return helper(maze, dp, start[0], start[1], destination[0], destination[1]);
        }

        private boolean helper(int[][] maze, int[][] dp, int i, int j, int di, int dj) {
            if (i == di && j == dj) return true;
            if (dp[i][j] != -1) return dp[i][j] == 1 ? true : false;
            boolean res = false;
            int m = maze.length, n = maze[0].length;
            maze[i][j] = -1;
            for (int[] dir : dirs) {
                int x = i, y = j;
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] != 1) {
                    x += dir[0]; y += dir[1];
                }
                x -= dir[0]; y -= dir[1];
                if (maze[x][y] != -1) {
                    res |= helper(maze, dp, x, y, di, dj);  // either way
                }
            }
            dp[i][j] = res ? 1 : 0;
            return res;
        }
    }

    public class UnitTest {



    }

}
