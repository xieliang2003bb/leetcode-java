package count_of_range_sum;

/**
 * Created by lxie on 8/29/18.
 */
public class CountOfRangeSum {

    public class Solution {

        public int countRangeSum(int[] nums, int lower, int upper) {
            long[] sums = new long[nums.length+1];
            for (int i = 0; i < nums.length; ++i) {
                sums[i + 1] = sums[i] + nums[i];
            }
            return countAndMergeSort(sums, 0, sums.length, lower, upper);
        }

        // j是第一个满足 sums[j] - sums[i] > upper 的下标
        // k是第一个满足 sums[k] - sums[i] >= lower 的下标
        // cache用于缓存merge sort结果(len=t)最后替换sums

        private int countAndMergeSort(long[] sums, int start, int end, int lower, int upper) {
            if (end - start <= 1) return 0;
            int mid = start + (end - start) / 2;
            int cnt = countAndMergeSort(sums, start, mid, lower, upper) + countAndMergeSort(sums, mid, end, lower, upper);
            int j = mid, k = mid, t = mid;
            long[] cache = new long[end-start];
            for (int i = start, r = 0; i < mid; ++i, ++r) {
                while (k < end && sums[k] - sums[i] < lower) ++k;
                while (j < end && sums[j] - sums[i] <= upper) ++j;
                while (t < end && sums[t] < sums[i]) cache[r++] = sums[t++];
                cache[r] = sums[i];
                cnt += j - k;
            }
            for (int i = 0; i < t-start; ++i) sums[start+i] = cache[i];
            return cnt;
        }
    }

    public class UnitTest {


    }
}
