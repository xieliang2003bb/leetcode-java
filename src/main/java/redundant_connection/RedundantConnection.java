package redundant_connection;

import java.util.Arrays;

/**
 * Created by lxie on 8/27/18.
 */
public class RedundantConnection {

    public class Solution {
        public int[] findRedundantDirectedConnection(int[][] edges) {
            int[] root = new int[2001];
            Arrays.fill(root, -1);
            for (int[] edge : edges) {
                int x = find(root, edge[0]), y = find(root, edge[1]);
                if (x == y) return edge;
                root[x] = y;
            }
            return null;
        }
        int find(int[] root, int i) {
            while (root[i] != -1) {
                i = root[i];
            }
            return i;
        }
    }

    public class UnitTest {

    }

}
