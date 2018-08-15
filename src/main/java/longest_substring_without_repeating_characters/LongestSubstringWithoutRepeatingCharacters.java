package longest_substring_without_repeating_characters;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters {

    public class Solution {
        public int lengthOfLongestSubstring(String s) {
            int[] m = new int[256]; Arrays.fill(m, -1);
            int res = 0, left = -1;
            for (int i = 0; i < s.length(); ++i) {
                left = Math.max(left, m[s.charAt(i)]);
                m[s.charAt(i)] = i;
                res = Math.max(res, i - left);
            }
            return res;
        }
    }

    public static class UnitTest {

    }
}
