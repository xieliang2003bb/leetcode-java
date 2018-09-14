package SubarraySumEqualsK;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lxie on 9/14/18.
 */
public class SubarraySumEqualsK {

    public class Solution {

        public int subarraySum(int[] nums, int k) {
            int res = 0, sum = 0, n = nums.length;
            Map<Integer, Integer> m = new HashMap<>();
            m.put(0, 1);

            for (int i = 0; i < n; ++i) {
                sum += nums[i];
                if (m.containsKey(sum - k)) {
                    res += m.get(sum - k);
                }
                if (m.containsKey(sum)) {
                    m.put(sum, m.get(sum)+1);
                } else {
                    m.put(sum, 1);
                }
            }
            return res;
        }
    }

    public class UnitTest {

    }

}
