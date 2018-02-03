package reverse_words_in_a_string;

public class ReverseWordsinaString {

    public class Solution {
        public String reverseWords(String s) {
            String[] tokens = s.split(" +");
            StringBuilder r = new StringBuilder();
            boolean isFirst = true;
            for (int i = tokens.length - 1; i >= 0; i--) {
                String token = tokens[i];
                if (token.isEmpty()) {
                    continue;
                }
                if (isFirst) {
                    isFirst = false;
                } else {
                    r.append(' ');
                }
                r.append(token);
            }
            return r.toString();
        }

        public String reverseWords1(String s0) {
            int left = 0; char[] s = s0.toCharArray();
            for (int i = 0; i <= s.length; ++i) {
                if (i == s.length || s[i] == ' ') {
                    reverse(s, left, i - 1);
                    left = i + 1;
                }
            }
            return new String(reverse(s, 0, s.length - 1));
        }

        public char[] reverse(char[] s, int left, int right) {
            while (left < right) {
                char t = s[left];
                s[left] = s[right];
                s[right] = t;
                ++left; --right;
            }
            return s;
        }
    }

    public static class UnitTest {

    }
}
