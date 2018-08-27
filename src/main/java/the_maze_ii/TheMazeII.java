package the_maze_ii;

import java.util.Arrays;

/**
 * Created by lxie on 8/27/18.
 */
public class TheMazeII {

    public class Solution {

        public int[][] dirs = {{0,-1},{-1,0},{0,1},{1,0}};

        public int shortestDistance(int[][] maze, int[] start, int[] destination) {
            int m = maze.length, n = maze[0].length;
            int[][] dists = new int[m][n];
            for (int[] a : dists) Arrays.fill(a, Integer.MAX_VALUE);

            dists[start[0]][start[1]] = 0;
            helper(maze, start[0], start[1], destination, dists);
            int res = dists[destination[0]][destination[1]];
            return (res == Integer.MAX_VALUE) ? -1 : res;
        }

        private void helper(int[][] maze, int i, int j, int[] destination, int[][] dists) {
            if (i == destination[0] && j == destination[1]) return;
            int m = maze.length, n = maze[0].length;
            for (int[] d : dirs) {
                int x = i, y = j, dist = dists[x][y];
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                    x += d[0];
                    y += d[1];
                    ++dist;
                }
                x -= d[0];
                y -= d[1];
                --dist;
                if (dists[x][y] > dist) {
                    dists[x][y] = dist;
                    helper(maze, x, y, destination, dists);
                }
            }
        }
    }

    public class UnitTest{

    }


}
