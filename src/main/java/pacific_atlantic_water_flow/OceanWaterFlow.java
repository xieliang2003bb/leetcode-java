package pacific_atlantic_water_flow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxie on 8/21/18.
 */
public class OceanWaterFlow {

    public class Solution {

        public List<int[]> pacificAtlantic(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();
            List<int[]> res = new ArrayList<>();
            int m = matrix.length, n = matrix[0].length;
            boolean[][] pacific = new boolean[m][n];
            boolean[][] atlantic = new boolean[m][n];
            for (int i = 0; i < m; ++i) {
                dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
                dfs(matrix, atlantic, Integer.MIN_VALUE, i, n - 1);
            }
            for (int i = 0; i < n; ++i) {
                dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
                dfs(matrix, atlantic, Integer.MIN_VALUE, m - 1, i);
            }
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (pacific[i][j] && atlantic[i][j]) {
                        int[] out = {i, j};
                        res.add(out);
                    }
                }
            }
            return res;
        }
        void dfs(int[][] matrix, boolean[][] visited, int pre, int i, int j) {
            int m = matrix.length, n = matrix[0].length;
            if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || matrix[i][j] < pre) return;
            visited[i][j] = true;
            dfs(matrix, visited, matrix[i][j], i + 1, j);
            dfs(matrix, visited, matrix[i][j], i - 1, j);
            dfs(matrix, visited, matrix[i][j], i, j + 1);
            dfs(matrix, visited, matrix[i][j], i, j - 1);
        }


    }

    public class UnitTest {



    }

}
