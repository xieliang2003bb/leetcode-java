package longest_palindromic_substring;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestPalindromicSubstring {

    public class Solution {
        public String longestPalindrome(String s) {
            // DP dp[i][j] -  if substr(i,j) is palindrome
            boolean [][] dp = new boolean[s.length()][s.length()];
            int left = 0, right = 0, len = 0;
            for (int i = 0; i < s.length(); ++i) {
                for (int j = 0; j < i; ++j) {
                    dp[j][i] = (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1] == true));
                    if (dp[j][i] && len < i - j + 1) {
                        len = i - j + 1;
                        left = j;
                        right = i;
                    }
                }
                dp[i][i] = true;
            }
            return s.substring(left, right + 1);
        }

    }

    public static class UnitTest {

        @Test
        public void testLongestPalindrome() {
            Solution s = new LongestPalindromicSubstring().new Solution();
            assertEquals("a", s.longestPalindrome("a"));
        }
    }
}
