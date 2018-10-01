package palindromic_substring;

/**
 * Created by lxie on 9/30/18.
 */
public class PalindromicSubstring {

    public class Solution {

        public int countSubstrings(String s) {
            int n = s.length(), res = 0;
            boolean[][] dp = new boolean[n][n];
            for (int i = n - 1; i >= 0; --i) {
                for (int j = i; j < n; ++j) {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);
                    if (dp[i][j]) ++res;
                }
            }
            return res;
        }
    }

    public class UnitTest {

    }

}
