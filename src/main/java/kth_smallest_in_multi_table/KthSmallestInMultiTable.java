package kth_smallest_in_multi_table;

/**
 * Created by lxie on 9/16/18.
 */
public class KthSmallestInMultiTable {

    public class Solution {

        public int findKthNumber(int m, int n, int k) {
            int left = 1, right = m * n;
            while (left < right) {
                int mid = left + (right - left) / 2, cnt = 0, i = m, j = 1;
                while (i >= 1 && j <= n) {
                    if (i * j <= mid) {
                        cnt += i;
                        ++j;
                    } else {
                        --i;
                    }
                }
                if (cnt < k) left = mid + 1;
                else right = mid;
            }
            return right;
        }
    }

    public class UnitTest {


    }
}
