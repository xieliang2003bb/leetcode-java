package sliding_window_maximum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lxie on 12/3/17.
 */
public class SlidingWindowMax {

    public static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            List<Integer> res = new ArrayList<>();
            LinkedList<Integer> q = new LinkedList<>();  // idx
            for (int i = 0; i < nums.length; ++i) {
                // remove when nums[i-k] is maximum, otherwise already removed
                if (!q.isEmpty() && q.getFirst() == i - k) q.removeFirst();
                while (!q.isEmpty() && nums[q.getLast()] < nums[i]) q.removeLast();
                q.add(i);
                if (i >= k - 1) res.add(nums[q.getFirst()]);
            }
            return res.stream().mapToInt(i->i).toArray();
        }
    }

    public static class UnitTest {

    }

}
