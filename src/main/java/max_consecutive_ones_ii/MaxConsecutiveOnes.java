package max_consecutive_ones_ii;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lxie on 9/22/18.
 */
public class MaxConsecutiveOnes {

    public class Solution {

        public int findMaxConsecutiveOnes(int[] nums) {
            int res = 0, left = 0, k = 1;
            Queue<Integer> q = new LinkedList<>();
            for (int right = 0; right < nums.length; ++right) {
                if (nums[right] == 0) q.add(right);
                if (q.size() > k) {
                    left = q.peek() + 1; q.poll();
                }
                res = Math.max(res, right - left + 1);
            }
            return res;
        }
    }

    public class UnitTest {



    }
}
