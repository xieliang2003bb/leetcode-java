package target_sum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lxie on 9/21/18.
 */
public class TargetSum {

    public class Solution {

        public int findTargetSumWays(int[] nums, int S) {
            List<Map<Integer, Integer>> dp = new ArrayList<>();
            for (int i = 0; i< nums.length; ++i)
                dp.add(new HashMap<>());
            return helper(nums, S, 0, dp);
        }

        private int helper(int[] nums, int sum, int start, List<Map<Integer, Integer>> dp) {
            if (start == nums.length) return sum == 0 ? 1 : 0;
            if (dp.get(start).containsKey(sum)) return dp.get(start).get(sum);
            int cnt1 = helper(nums, sum - nums[start], start + 1, dp);
            int cnt2 = helper(nums, sum + nums[start], start + 1, dp);
            dp.get(start).put(sum, cnt1 + cnt2);
            return cnt1 + cnt2;
        }

    }

    public class UnitTest {



    }

}
