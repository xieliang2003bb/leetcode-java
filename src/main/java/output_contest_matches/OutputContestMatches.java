package output_contest_matches;

import java.util.Arrays;

/**
 * Created by lxie on 9/16/18.
 */
public class OutputContestMatches {

    public static class Solution {

        public String findContestMatch(int n) {
            String[] v = new String[n+1]; Arrays.fill(v, "");
            for (int i = 1; i <= n; ++i) v[i-1] = Integer.toString(i);
            helper(n, v);
            return v[0];
        }
        void helper(int n, String[] v) {
            if (n == 1) return;
            for (int i = 0; i < n; ++i) {
                v[i] = "(" + v[i] + "," + v[n - i - 1] + ")";
            }
            helper(n / 2, v);
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String res = s.findContestMatch(8);
        System.out.println(res);

    }
}
