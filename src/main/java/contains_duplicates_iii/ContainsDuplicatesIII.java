package contains_duplicates_iii;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lxie on 2/13/18.
 */
public class ContainsDuplicatesIII {

    public static class Solution {

        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            Map<Integer, Integer> m = new HashMap<>();
            int j = 0;
            for (int i = 0; i < nums.length; ++i) {
                if (i - j > k && m.get(nums[j]) == j) m.remove(nums[j++]);
                int[] lower = new int[1];
                boolean a = lower_bound(m, (long) nums[i] - t, lower);
                if (a && Math.abs((long) lower[0] - nums[i]) <= t) return true;
                m.put(nums[i], i);
            }
            return false;
        }


        // TODO - need a better algorithm !!!
        private boolean lower_bound(Map<Integer, Integer> m, long v, int[] res) {
            long min_diff = Long.MAX_VALUE;
            for (int key : m.keySet()) {
                if (key >= v && key - v < min_diff)
                    min_diff = key - v;
            }
            if (min_diff == Long.MAX_VALUE)
                return false;
            else {
                res[0] = (int) (v + min_diff);
                return true;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("this is for test");
        Solution sol = new Solution();
        int[] a = {2147483647, -2147483647};
        boolean res = sol.containsNearbyAlmostDuplicate(a, 1, 2147483647);
        System.out.println(res);
    }
}
