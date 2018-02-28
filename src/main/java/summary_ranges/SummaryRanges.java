package summary_ranges;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxie on 2/28/18.
 */
public class SummaryRanges {

    public class Solution {
        public List<String> summaryRanges(int[] nums) {
            List<String> res = new ArrayList<>();
            int i = 0, n = nums.length;
            while (i < n) {
                int j = 1;
                while (i + j < n && nums[i + j] - nums[i] == j) ++j;
                res.add(j <= 1 ? Integer.toString(nums[i]) : Integer.toString(nums[i]) +
                        "->" + Integer.toString(nums[i + j - 1]));
                i += j;
            }
            return res;
        }
    }

    public static class UnitTest {

    }

}
