package smaller_numbers_after_self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lxie on 7/2/18.
 */
public class SmallerAfterSelf {

    public class Solution {

        public List<Integer> countSmaller(int[] nums) {
            List<Integer> t = new ArrayList<>();
            Integer[] res = new Integer[nums.length];
            for (int i = nums.length - 1; i >= 0; --i) {
                int left = 0, right = t.size();
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (t.get(mid) >= nums[i]) right = mid;
                    else left = mid + 1;
                }
                res[i] = right; // for each i get count
                t.add(right, nums[i]);
            }
            return Arrays.asList(res);
        }
    }

    public class UnitTest4 {

    }

}
