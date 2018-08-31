package max_xor_two_numbers_in_array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lxie on 8/31/18.
 */
public class MaxXorTwoNumbersInArray {

    public class Solution {

        public int findMaximumXOR(int[] nums) {
            int res = 0, mask = 0;
            for (int i = 31; i >= 0; --i) {
                mask |= (1 << i);
                Set<Integer> s = new HashSet<>();
                for (int num : nums) {
                    s.add(num & mask);
                }
                int t = res | (1 << i);
                for (int prefix : s) {
                    if (s.contains(t ^ prefix)) {
                        res = t;
                        break;
                    }
                }
            }
            return res;
        }
    }

    public class UnitTest {



    }

}
