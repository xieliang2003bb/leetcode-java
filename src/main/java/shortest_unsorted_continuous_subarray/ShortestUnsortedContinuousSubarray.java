package shortest_unsorted_continuous_subarray;

/**
 * Created by lxie on 9/13/18.
 */
public class ShortestUnsortedContinuousSubarray {

    public class Solution {

        public int findUnsortedSubarray(int[] nums) {
            int n = nums.length, start = -1, end = -2;
            int mn = nums[n - 1], mx = nums[0];
            for (int i = 1; i < n; ++i) {
                mx = Math.max(mx, nums[i]);
                mn = Math.min(mn, nums[n - 1 - i]);
                if (mx > nums[i]) end = i;
                if (mn < nums[n - 1 - i]) start = n - 1 - i;
            }
            return end - start + 1;
        }
    }

    public class UnitTest {

    }



}
