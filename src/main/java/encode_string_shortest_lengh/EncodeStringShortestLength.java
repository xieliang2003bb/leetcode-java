package encode_string_shortest_lengh;

/**
 * Created by lxie on 8/25/18.
 */
public class EncodeStringShortestLength {

    public static class Solution {

        public String encode(String s) {
            int n = s.length();
            String[][] dp = new String[n][n];
            for (int step = 1; step <= n; ++step) {
                for (int i = 0; i + step - 1 < n; ++i) {
                    int j = i + step - 1;
                    dp[i][j] = s.substring(i, i+step);
                    for (int k = i; k < j; ++k) {
                        String left = dp[i][k], right = dp[k + 1][j];
                        if (left.length() + right.length() < dp[i][j].length()) {
                            dp[i][j] = left + right;
                        }
                    }
                    String t = s.substring(i, j+1), replace = "";
                    int pos = (t + t).indexOf(t, 1);
                    if (pos >= t.length()) replace = t;
                    else replace = Integer.toString(t.length() / pos) + '[' + dp[i][i + pos - 1] + ']';
                    if (replace.length() < dp[i][j].length()) dp[i][j] = replace;
                }
            }
            return dp[0][n - 1];
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.encode("abbbabbbcabbbabbbc"));

    }
}
