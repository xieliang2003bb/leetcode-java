package missing_range;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxie on 8/19/18.
 */
public class MissingRange {

    public class Solution {
        public List<String> findMissingRanges(List<Integer> nums, int lower, int upper) {
            List<String> res = new ArrayList<>();
            int l = lower;
            for (int i = 0; i <= nums.size(); ++i) {
                int r = (i < nums.size() && nums.get(i) <= upper) ? nums.get(i) : upper + 1;
                if (l == r) ++l;
                else if (r > l) {
                    res.add(r - l == 1 ? Integer.toString(l) : Integer.toString(l) + "->" +
                            Integer.toString(r - 1));
                    l = r + 1;
                }
            }
            return res;
        }
    }

    public class UnitTest {


    }
}
