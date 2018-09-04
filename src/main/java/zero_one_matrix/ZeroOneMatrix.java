package zero_one_matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lxie on 9/3/18.
 */
public class ZeroOneMatrix {

    public class Solution {

        public int[][] updateMatrix(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            int[][] dirs = {{0,-1},{-1,0},{0,1},{1,0}};
            Queue<int[]> q = new LinkedList<>();
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (matrix[i][j] == 0) q.add(new int[]{i, j});
                    else matrix[i][j] = Integer.MAX_VALUE;
                }
            }
            while (!q.isEmpty()) {
                int[] t = q.peek(); q.poll();
                for (int[] dir : dirs) {
                    int x = t[0] + dir[0], y = t[1] + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n ||
                            matrix[x][y] <= matrix[t[0]][t[1]]) continue;
                    matrix[x][y] = matrix[t[0]][t[1]] + 1;
                    q.add(new int[]{x, y});
                }
            }
            return matrix;
        }
    }

    public class UnitTest {



    }


}
