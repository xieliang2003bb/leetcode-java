package evaluate_division;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lxie on 8/22/18.
 */
public class EvaluateDivision {

    public static class Solution {

        public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
            double[] res = new double[queries.length];
            for (int i=0; i<res.length; ++i) res[i] = -1.0;
            Set<String> s = new HashSet<>();
            for (String[] a : equations) {
                s.add(a[0]);
                s.add(a[1]);
            }
            for (int i = 0; i < queries.length; ++i) {
                String[] query = queries[i];
                if (s.contains(query[0]) && s.contains(query[1])) {
                    List<Integer> v = new ArrayList<>(); // visited exprs
                    res[i] = helper(equations, values, query, v);
                }
            }
            return res;
        }

        private double helper(String[][] equations, double[] values, String[] query, List<Integer> v) {
            for (int i = 0; i < equations.length; ++i) {
                if (equations[i][0] == query[0] && equations[i][1] == query[1]) return values[i];
                if (equations[i][0] == query[1] && equations[i][1] == query[0]) return 1.0 / values[i];
            }
            for (int i = 0; i < equations.length; ++i) {
                if (!v.contains(i) && equations[i][0] == query[0]) { // case 1, 2
                    v.add(i); // visited
                    String[] expr = {equations[i][1], query[1]};
                    double t = values[i] * helper(equations, values, expr, v);
                    if (t > 0) return t;
                    else v.remove(v.size()-1);
                }
                if (!v.contains(i) && equations[i][1] == query[0]) { // case 3
                    v.add(i);
                    String[] expr = {equations[i][0], query[1]};
                    double t = helper(equations, values, expr, v) / values[i];
                    if (t > 0) return t;
                    else v.remove(v.size()-1);
                }
            }
            return -1.0;
        }


    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[][] equations = {{"a", "b"}, {"b", "c"}};
        double[] values = {2.0, 3.0};
        String[][] queries = {{"a", "c"}, {"b", "c"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        double[] res = sol.calcEquation(equations, values, queries);
        System.out.println(res.toString());
    }

}
