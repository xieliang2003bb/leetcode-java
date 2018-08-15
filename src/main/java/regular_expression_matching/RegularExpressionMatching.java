package regular_expression_matching;


public class RegularExpressionMatching {

    public class Solution {
        public boolean isMatch(String s, String p) {
            if (p.isEmpty()) return s.isEmpty();
            if (p.length() == 1) {
                return (s.length() == 1 && (s.charAt(0) == p.charAt(0) ||
                        p.charAt(0) == '.'));
            }
            if (p.charAt(1) != '*') {
                if (s.isEmpty()) return false;
                return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') &&
                        isMatch(s.substring(1), p.substring(1));
            }
            while (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
                if (isMatch(s, p.substring(2))) return true;
                s = s.substring(1);
            }
            return isMatch(s, p.substring(2));
        }

    }

    public static class UnitTest {
    }
}
