package longest_increasing_subsequence;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxie on 6/22/18.
 */
public class LongestIncSubsequence {

    public class Solution {

        // O(n^2)
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            for (int i=0; i<dp.length; ++i) dp[i] = 1;
            int res = 0;
            for (int i = 0; i < nums.length; ++i) {
                for (int j = 0; j < i; ++j) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                res = Math.max(res, dp[i]);
            }
            return res;
        }

        // O(nlogn)
        public int lengthOfLIS1(int[] nums) {
            if (nums.length == 0) return 0;
            List<Integer> ends = new ArrayList<>();
            ends.add(nums[0]);
            for (int a : nums) {
                if (a < ends.get(0)) ends.set(0, a);
                else if (a > ends.get(ends.size()-1)) ends.add(a);
                else {
                    int left = 0, right = ends.size();
                    while (left < right) {
                        int mid = left + (right - left) / 2;
                        if (ends.get(mid) < a) left = mid + 1;
                        else right = mid;
                    }
                    ends.set(right, a); // find first >= a and replace it
                }
            }
            return ends.size();
        }

    }

    public class UnitTest {

    }
}
