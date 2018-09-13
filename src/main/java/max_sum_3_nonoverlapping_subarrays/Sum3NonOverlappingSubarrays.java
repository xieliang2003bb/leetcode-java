package max_sum_3_nonoverlapping_subarrays;

import java.util.Arrays;

/**
 * Created by lxie on 9/13/18.
 */
public class Sum3NonOverlappingSubarrays {

    public class Solution {

        public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
            int n = nums.length, mx = Integer.MIN_VALUE;
            int[] sums = new int[n+1];
            int[] res = new int[3];
            int[] left = new int[n];
            int[] right = new int[n]; Arrays.fill(right, n-k);
            for (int i = 0; i < n; ++i) sums[i+1] = sums[i] + nums[i]; // sums[0] = 0

            for (int i = k, total = sums[k] - sums[0]; i < n; ++i) {
                if (sums[i + 1] - sums[i + 1 - k] > total) {
                    left[i] = i + 1 - k;
                    total = sums[i + 1] - sums[i + 1 - k];
                } else {
                    left[i] = left[i - 1];
                }
            }
            for (int i = n - 1 - k, total = sums[n] - sums[n - k]; i >= 0; --i) {
                if (sums[i + k] - sums[i] >= total) {
                    right[i] = i;
                    total = sums[i + k] - sums[i];
                } else {
                    right[i] = right[i + 1];
                }
            }
            for (int i = k; i <= n - 2 * k; ++i) {
                int l = left[i - 1], r = right[i + k];
                int total = (sums[i + k] - sums[i]) + (sums[l + k] - sums[l]) + (sums[r + k] - sums[r]);
                if (mx < total) {
                    mx = total;
                    res[0] = l; res[1] = i; res[2] = r;
                }
            }
            return res;
        }




    }

    public class UnitTest {


    }

}
