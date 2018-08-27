package longest_consecutive_sequence;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {

    public class Solution {
        public int longestConsecutive(int[] nums) {
            int res = 0;
            Map<Integer, Integer> m = new HashMap<>();
            for (int d : nums) {
                if (!m.containsKey(d)) {
                    int left = m.containsKey(d - 1) ? m.get(d - 1) : 0;
                    int right = m.containsKey(d + 1) ? m.get(d + 1) : 0;
                    int sum = left + right + 1;
                    m.put(d, sum);
                    res = Math.max(res, sum);
                    m.put(d - left, sum);
                    m.put(d + right, sum);
                }
            }
            return res;
        }
    }

    public static class UnitTest {

    }
}
