package shortest_distance_from_all_buildings;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lxie on 1/30/18.
 */
public class ShortestDistanceToBuildings {

    public class Solution {

        public int shortestDistance(int[][] grid) {
            int res = Integer.MAX_VALUE, val = 0, m = grid.length, n = grid[0].length;
            int[][] sum = grid;
            int[][] dirs = {{0,-1},{-1,0},{0,1},{1,0}};
            for (int i = 0; i < grid.length; ++i) {
                for (int j = 0; j < grid[i].length; ++j) {
                    if (grid[i][j] == 1) {
                        res = Integer.MAX_VALUE;
                        int[][] dist = grid;
                        Queue<int[]> q = new LinkedList<>();
                        q.add(new int[]{i, j});
                        while (!q.isEmpty()) {
                            int a = q.peek()[0], b = q.peek()[1]; q.poll();
                            for (int k = 0; k < dirs.length; ++k) {
                                int x = a + dirs[k][0], y = b + dirs[k][1];
                                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == val) {
                                    --grid[x][y];
                                    dist[x][y] = dist[a][b] + 1;
                                    sum[x][y] += dist[x][y] - 1;
                                    q.add(new int[]{x, y});
                                    res = Integer.min(res, sum[x][y]);
                                }
                            }
                        }
                        --val;    // empty land changes in each BFS
                    }
                }
            }
            return res == Integer.MAX_VALUE ? -1 : res;
        }
    }


    public static class UnitTest {

    }

}
