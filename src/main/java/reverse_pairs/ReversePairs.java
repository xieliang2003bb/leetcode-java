package reverse_pairs;

import java.util.Arrays;

/**
 * Created by lxie on 9/21/18.
 */
public class ReversePairs {

    public class Solution {

        public int reversePairs(int[] nums) {
            return mergeSort(nums, 0, nums.length - 1);
        }

        private int mergeSort(int[] nums, int left, int right) {
            if (left >= right) return 0;
            int mid = left + (right - left) / 2;
            int res = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
            for (int i = left, j = mid + 1; i <= mid; ++i) {
                while (j <= right && nums[i] / 2.0 > nums[j]) ++j;
                res += j - (mid + 1);
            }
            Arrays.sort(nums, left, right + 1);
            return res;
        }
    }

    public class UnitTest {



    }
}
