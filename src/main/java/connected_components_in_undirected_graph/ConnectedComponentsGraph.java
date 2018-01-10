package connected_components_in_undirected_graph;

import java.util.*;

/**
 * Created by lxie on 1/10/18.
 */
public class ConnectedComponentsGraph {

    class Solution {
        public int NumberOfConnectedComponents(int n, int[][] edges) {
            if (n == 0) return 0;
            int res = 0;
            List<Set<Integer>> g = new ArrayList<>(n);
            List<Boolean> v = new ArrayList<>(n);
            for (int i = 0; i < n; ++i) {
                g.add(new HashSet<>());
                v.add(false);
            }
            for (int[] edge : edges) {
                g.get(edge[0]).add(edge[1]);
                g.get(edge[1]).add(edge[0]);
            }

            for (int i = 0; i < n; ++i) {
                if (v.get(i) == false) {
                    ++res;
                    dfs(g, v, i);
                }
            }
            return res;
        }

        void dfs(List<Set<Integer>> g, List<Boolean> v, int i) {
            if (v.get(i) == true) return;
            v.set(i, true);
            for (int j : g.get(i)) {
                dfs(g, v, j);
            }
        }


    }

    public static class UnitTest {

    }




}
