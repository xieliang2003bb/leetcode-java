package search_for_a_range;

public class SearchforaRange {

    public class Solution {

        public int[] searchRange(int[] nums, int target) {
            int[] res = new int[] {-1, -1};
            if (nums.length == 0) return res;
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) left = mid + 1;
                else right = mid;
            }
            if (nums[right] != target) return res;
            res[0] = right;
            right = nums.length; // edge case - left=0, right=0
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] <= target) left = mid + 1;
                else right= mid;
            }
            res[1] = left - 1;
            return res;
        }
    }

    public static class UnitTest {

    }
}
