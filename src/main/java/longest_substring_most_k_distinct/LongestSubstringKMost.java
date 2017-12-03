package longest_substring_most_k_distinct;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.max;

/**
 * Created by lxie on 12/2/17.
 */
public class LongestSubstringKMost {
    public static class Solution {
        private int LongestSubstringKMost(String s, int k) {
            int res = 0, left = 0;
            Map<Character, Integer> m = new HashMap<>();
            for (int i = 0; i < s.length(); ++i) {
                if (!m.containsKey(s.charAt(i))) m.put(s.charAt(i), 1);
                else
                    m.put(s.charAt(i), m.get(s.charAt(i))+1);
                while (m.size() > k) {
                    if (m.get(s.charAt(left)) == 1) m.remove(s.charAt(left));
                    else
                        m.put(s.charAt(left), m.get(s.charAt(left))-1);
                    ++left;
                }
                res = max(res, i - left + 1);
            }
            return res;

        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("result = " + sol.LongestSubstringKMost("eceba", 2));
    }
}
