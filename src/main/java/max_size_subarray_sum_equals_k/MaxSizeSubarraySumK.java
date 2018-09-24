package max_size_subarray_sum_equals_k;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lxie on 9/24/18.
 */
public class MaxSizeSubarraySumK {

    public class Solution {

        public int maxSubArrayLen(int[] nums, int k) {
            int sum = 0, res = 0;
            Map<Integer, Integer> m = new HashMap<>();
            for (int i = 0; i < nums.length; ++i) {
                sum += nums[i];
                if (sum == k) res = i + 1;
                else if (m.containsKey(sum - k)) res = Math.max(res, i - m.get(sum - k));
                if (!m.containsKey(sum)) m.put(sum, i);  // records earliest idx only
            }
            return res;
        }
    }

    public class UnitTest {



    }

}
