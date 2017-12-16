package shortest_palindrome;

/**
 * Created by lxie on 12/15/17.
 */
public class ShortestPalindrome {
    public class Solution {
        public String shortestPalindrome(String s) {
            String r = s;
            r = new StringBuilder(r).reverse().toString();
            char[] t = (s + "#" + r).toCharArray();
            int[] p = new int[t.length];
            for (int i = 1; i < t.length; ++i) {
                int j = p[i - 1];
                while (j > 0 && t[i] != t[j]) j = p[j - 1];
                p[i] = (j += (t[i] == t[j] ? 1 : 0));
            }
            return r.substring(0, s.length() - p[t.length - 1]) + s;
        }

    }

    public static class UnitTest {

    }
}
