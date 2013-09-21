package search_insert_position;

public class SearchInsertPosition {

    public class Solution {
        public int searchInsert(int[] A, int target) {
            int left = 0;
            int right = A.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (A[mid] < target) {
                    left = mid + 1;
                } else if (A[mid] > target) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            }
            return left;
        }
    }

    public static class UnitTest {

    }
}
