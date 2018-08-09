package combinations;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public class Solution {

        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer> > res = new ArrayList<>();
            List<Integer> out = new ArrayList<>();
            combineDFS(n, k, 1, out, res);
            return res;
        }

        private void combineDFS(int n, int k, int level, List<Integer> out, List<List<Integer> > res) {
            if (out.size() == k) res.add(new ArrayList<>(out));
            else {
                for (int i = level; i <= n; ++i) {
                    out.add(i);
                    combineDFS(n, k, i + 1, out, res);
                    out.remove(out.size()-1);
                }
            }
        }

    }

    public static class UnitTest {

    }
}
