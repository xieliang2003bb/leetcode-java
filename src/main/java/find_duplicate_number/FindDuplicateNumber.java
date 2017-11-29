package find_duplicate_number;

/**
 * Created by lxie on 11/29/17.
 */
public class FindDuplicateNumber {

    public class Solution {
        public int findDuplicate(int[] nums)  {
            int low = 1, high = nums.length - 1; // from 1 to n
            while (low < high) {
                int mid = low + (high - low) / 2;
                int cnt = 0;
                for (int a : nums) {
                    if (a <= mid) ++cnt;
                }
                if (cnt <= mid) low = mid + 1;
                else high = mid;
            }
            return low;

        }
    }

    public static class UnitTest {

    }


}
