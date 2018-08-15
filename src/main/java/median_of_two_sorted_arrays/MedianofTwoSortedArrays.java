package median_of_two_sorted_arrays;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MedianofTwoSortedArrays {

    public class Solution {

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length, n = nums2.length, left = (m + n + 1) / 2, right = (m + n + 2) / 2;
            return (findKth(nums1, nums2, left) + findKth(nums1, nums2, right)) / 2.0;
        }
        int findKth(int[] nums1, int[] nums2, int k) {
            int m = nums1.length, n = nums2.length;
            if (m > n) return findKth(nums2, nums1, k);
            if (m == 0) return nums2[k - 1];
            if (k == 1) return Math.min(nums1[0], nums2[0]);
            int i = Math.min(m, k / 2), j = Math.min(n, k / 2);
            if (nums1[i - 1] > nums2[j - 1]) {
                return findKth(nums1, Arrays.copyOfRange(nums2, j, n), k - j);
            } else {
                return findKth(Arrays.copyOfRange(nums1, i, m), nums2, k - i);
            }
        }
    }

    public static class UnitTest {

        @Test
        public void testFindMedianSortedArrays() {
            Solution s = new MedianofTwoSortedArrays().new Solution();
            assertEquals(2.5, s.findMedianSortedArrays(new int[]{3, 4}, new int[]{1, 2}), 1E-6);
        }
    }
}
