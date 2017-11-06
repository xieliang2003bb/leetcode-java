package largest_divisible_subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lxie on 11/6/17.
 */
public class LargestDivisibleSubset {

    public class Solution {

        public List<Integer> largestDivisibleSubset(int[] nums) {
            Arrays.sort(nums);
            List<Integer> res = new ArrayList<>();
            int[] dp = new int[nums.length];
            int[] parent = new int[nums.length];
            int mx = 0, mx_idx = 0;
            for (int i = nums.length - 1; i >= 0; --i) {
                for (int j = i; j < nums.length; ++j) {
                    if (nums[j] % nums[i] == 0 && dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        parent[i] = j;
                        if (mx < dp[i]) {
                            mx = dp[i];
                            mx_idx = i;
                        }
                    }
                }
            }
            for (int i = 0; i < mx; ++i) {
                res.add(nums[mx_idx]);
                mx_idx = parent[mx_idx];   // a good way to track
            }
            return res;
        }
    }

    public static class UnitTest {

    }

}
