package number_of_islands_ii;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxie on 1/23/18.
 */
public class NumberOfIslandsII {

    public class Solution {

        public List<Integer> numIslands2(int m, int n, int[][] positions) {
            List<Integer> res = new ArrayList<>();
            if (m <= 0 || n <= 0) return res;
            int[] roots = new int[m*n];
            for (int i=0; i<m*n-1; ++i) roots[i] = -1;
            int cnt = 0;
            int[][] dirs = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
            for (int[] a : positions) {
                int id = n * a[0] + a[1];
                roots[id] = id;
                ++cnt;
                for (int[] d : dirs) {
                    int x = a[0] + d[0], y = a[1] + d[1];
                    int cur_id = n * x + y;
                    if (x < 0 || x >= m || y < 0 || y >= n || roots[cur_id] == -1) continue;
                    int new_id = findRoots(roots, cur_id);
                    if (id != new_id) {
                        roots[id] = new_id;
                        id = new_id;
                        --cnt;
                    }
                }
                res.add(cnt);
            }
            return res;
        }

        // union find
        private int findRoots(int[] roots, int id) {
            while (id != roots[id]) {
                roots[id] = roots[roots[id]];  // path compression
                id = roots[id];
            }
            return id;
        }
    }

    public static class UnitTest {

    }

}
