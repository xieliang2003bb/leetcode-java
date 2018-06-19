package word_pattern_ii;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lxie on 6/19/18.
 */
public class WordPatternII {

    public static class Solution{

        public boolean wordPatternMatch(String pattern, String str) {
            Map<Character, String> m = new HashMap<>();
            return helper(pattern, 0, str, 0, m);
        }

        private boolean helper(String pattern, int p, String str, int r, Map<Character, String> m) {
            if (p == pattern.length() && r == str.length()) return true;
            if (p == pattern.length() || r == str.length()) return false;
            char c = pattern.charAt(p);
            for (int i = r; i < str.length(); ++i) {
                String t = str.substring(r, i+1);
                if (m.containsKey(c) && m.get(c).equals(t)) {
                    if (helper(pattern, p + 1, str, i + 1, m)) return true;
                } else if (!m.containsKey(c)) {
                    boolean b = false;
                    for (Map.Entry<Character, String> it : m.entrySet()) {
                        if (it.getValue().equals(t)) b = true;
                    }
                    if (!b) {
                        m.put(c, t);
                        if (helper(pattern, p + 1, str, i + 1, m)) return true;
                        m.remove(c); // backtracking
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("this is for test");
        Solution sol = new Solution();

        //pattern = "abab", str = "redblueredblue" should return true.
        //pattern = "aaaa", str = "asdasdasdasd" should return true.
        //pattern = "aabb", str = "xyzabcxzyabc" should return false.
        System.out.println(sol.wordPatternMatch("abab", "redblueredblue"));
        System.out.println(sol.wordPatternMatch("aaaa", "asdasdasdasd"));
        System.out.println(sol.wordPatternMatch("aabb", "xyzabcxzyabc"));

    }

}
