package longest_common_prefix;

public class LongestCommonPrefix {

    public class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) return "";
            String res = "";
            for (int j = 0; j < strs[0].length(); ++j) {
                char c = strs[0].charAt(j);
                for (int i = 1; i < strs.length; ++i) {
                    if (j >= strs[i].length() || strs[i].charAt(j) != c) {
                        return res;
                    }
                }
                res += c;
            }
            return res;
        }

    }

    public static class UnitTest {

    }
}
