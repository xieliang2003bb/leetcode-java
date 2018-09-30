package continuous_subarray_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lxie on 9/29/18.
 */
public class ContinuousSubarraySum {

    public class Solution {

        public boolean checkSubarraySum(int[] nums, int k) {
            int n = nums.length, sum = 0;
            Map<Integer, Integer> m = new HashMap<>();
            m.put(0, -1);
            for (int i = 0; i < n; ++i) {
                sum += nums[i];
                int t = (k == 0) ? sum : (sum % k);
                if (m.containsKey(t)) {
                    if (i - m.get(t) > 1) return true;
                } else m.put(t, i);
            }
            return false;
        }

    }

    public class UnitTest {


    }

}
