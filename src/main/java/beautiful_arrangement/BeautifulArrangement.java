package beautiful_arrangement;

/**
 * Created by lxie on 7/24/18.
 */
public class BeautifulArrangement {

    public class Solution {

        public int countArrangement(int N) {
            int[] res = {0};
            int[] visited = new int[N + 1];
            helper(N, visited, 1, res);
            return res[0];
        }
        void helper(int N, int[] visited, int pos, int[] res) {
            if (pos > N) {
                ++res[0];
                return;
            }
            for (int i = 1; i <= N; ++i) {
                if (visited[i] == 0 && (i % pos == 0 || pos % i == 0)) {
                    visited[i] = 1;
                    helper(N, visited, pos + 1, res);
                    visited[i] = 0;
                }
            }
        }
    }

    public class UnitTest {

    }


}
