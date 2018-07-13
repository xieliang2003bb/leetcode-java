package longest_palindrome;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lxie on 7/13/18.
 */
public class LongestPalindrome {

    public class Solution {
        int longestPalindrome(String s) {
            int res = 0;
            boolean mid = false;
            Map<Character, Integer> m = new HashMap<>();
            for (char c : s.toCharArray()) {
                if (!m.containsKey(c)) {
                    m.put(c, 1);
                } else {
                    m.put(c, m.get(c) + 1);
                }
            };

            for (Map.Entry<Character, Integer> it: m.entrySet()) {
                res += it.getValue();
                if (it.getValue() % 2 == 1) {
                    res -= 1;
                    mid = true;
                }
            }
            return mid ? res + 1 : res;
        }
    }

    public class UnitTest {

    }
}
