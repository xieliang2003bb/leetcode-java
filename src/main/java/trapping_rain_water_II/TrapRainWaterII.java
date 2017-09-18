package trapping_rain_water_II;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by lxie on 9/18/17.
 */
public class TrapRainWaterII {

    static class Solution {
        public int trapRainWater(int[][] heightMap) {
            if(heightMap.length == 0) return 0;
            int m = heightMap.length, n = heightMap[0].length, res = 0, mx = Integer.MIN_VALUE;
            PairComparator comparator = new PairComparator();
            PriorityQueue<Pair<Integer, Integer>> q = new PriorityQueue<>(100, comparator);
            boolean[][] visited = new boolean[m][n];
            int[][] dir = {{0,-1},{-1,0},{0,1},{1,0}};
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                        q.offer(new Pair(heightMap[i][j], i * n + j));
                        visited[i][j] = true;
                    }
                }
            }
            while (!q.isEmpty()) {
                Pair<Integer, Integer> t = q.poll();
                int h = t.getKey(), r = t.getValue() / n, c = t.getValue() % n;
                mx = Math.max(mx, h);
                for (int i = 0; i < dir.length; ++i) {
                    int x = r + dir[i][0], y = c + dir[i][1];
                    if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) continue;
                    visited[x][y] = true;
                    if (heightMap[x][y] < mx) res += mx - heightMap[x][y];  // LC 42
                    q.offer(new Pair(heightMap[x][y], x * n + y));
                }
            }
            return res;

        }

        class PairComparator implements Comparator<Pair<Integer, Integer>> {
            @Override
            public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                return p1.getKey() - p2.getKey();
            }
        }

    }


    public static void main(String[] args) {
        System.out.println("this is for test");
        Solution sol = new Solution();
        int[][] heightMap = {{1,4,3,1,3,2}, {3,2,1,3,2,4}, {2,3,3,2,3,1}};
        int res = sol.trapRainWater(heightMap);
        System.out.println(res);
    }



}
