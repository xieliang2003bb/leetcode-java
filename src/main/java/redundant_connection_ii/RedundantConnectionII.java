package redundant_connection_ii;

/**
 * Created by lxie on 9/11/18.
 */
public class RedundantConnectionII {

    public class Solution {

        public int[] findRedundantDirectedConnection(int[][] edges) {
            int n = edges.length;
            int[] root = new int[n+1];
            int[] first = new int[2], second = new int[2];
            for (int[] edge : edges) {
                if (root[edge[1]] == 0) {
                    root[edge[1]] = edge[0];
                } else {
                    first[0] = root[edge[1]]; first[1] = edge[1];
                    second[0] = edge[0]; second[1] = edge[1];
                    edge[1] = 0;
                }
            }
            for (int i = 0; i <= n; ++i) root[i] = i;
            for (int[] edge : edges) {
                if (edge[1] == 0) continue;
                int x = getRoot(root, edge[0]), y = getRoot(root, edge[1]);
                if (x == y) return first[0] == 0 ? edge : first;
                root[x] = y;
            }
            return second;
        }

        private int getRoot(int[] root, int i) {
            return i == root[i] ? i : getRoot(root, root[i]);
        }


    }

    public class UnitTest {


    }

}
