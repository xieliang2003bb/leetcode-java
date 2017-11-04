package kth_smallest_in_sorted_matrix;

/**
 * Created by lxie on 11/3/17.
 */
public class kthSmallestSortMatrix {

    public class Solution {

        public int kthSmallest(int[][] matrix, int k) {
            int n = matrix.length;
            int left = matrix[0][0], right = matrix[n-1][n-1];
            while (left < right) {
                int mid = left + (right - left) / 2;
                int cnt = search_less_equal(matrix, mid);
                if (cnt < k) left = mid + 1;
                else right = mid;
            }
            return left;
        }

        public int search_less_equal(int[][] matrix, int target) {
            int n = matrix.length, i = n - 1, j = 0, res = 0;
            while (i >= 0 && j < n) {
                if (matrix[i][j] <= target) {
                    res += i + 1;
                    ++j;
                } else {
                    --i;
                }
            }
            return res;
        }

    }

    public static class UnitTest {

    }

}
