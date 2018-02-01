package longest_substr_at_most_two_distinct_chars;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lxie on 2/1/18.
 */
public class LongestStrTwoDistinct {

    public static class Solution {

        public int lengthOfLongestSubstringTwoDistinct(String s) {
            int res = 0, left = 0;
            Map<Character, Integer> m = new HashMap<>();
            char[] s1 = s.toCharArray();

            for (int i = 0; i < s.length(); ++i) {
                if (!m.containsKey(s1[i])) {
                    m.put(s1[i], 1);
                } else {
                    m.put(s1[i], m.get(s1[i])+1);
                }

                while (m.size() > 2) {
                    m.put(s1[left], m.get(s1[left])-1);
                    if (m.get(s1[left]) == 0) m.remove(s1[left]);
                    ++left;
                }
                res = Integer.max(res, i - left + 1);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println("this is for test");
        Solution sol = new Solution();
        int res = sol.lengthOfLongestSubstringTwoDistinct("eceba");
        System.out.println(res);
    }

}
