package binary_watch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxie on 7/14/18.
 */
public class BinaryWatch {

    public class Solution {

        public List<String> readBinaryWatch(int num) {
            List<String> res = new ArrayList<>();
            int[] hour = {8, 4, 2, 1}; int[] minute = {32, 16, 8, 4, 2, 1};
            for (int i = 0; i <= num; ++i) {
                List<Integer> hours = generate(hour, i);
                List<Integer> minutes = generate(minute, num - i);
                for (int h : hours) {
                    if (h > 11) continue;
                    for (int m : minutes) {
                        if (m > 59) continue;
                        res.add(Integer.toString(h) + (m < 10 ? ":0" : ":") + Integer.toString(m));
                    }
                }
            }
            return res;
        }

        private List<Integer> generate(int[] nums, int cnt) {
            List<Integer> res = new ArrayList<>();
            helper(nums, cnt, 0, 0, res);
            return res;
        }

        private void helper(int[] nums, int cnt, int pos, int out, List<Integer> res) {
            if (cnt == 0) {
                res.add(out);
                return;
            }
            for (int i = pos; i < nums.length; ++i) {
                helper(nums, cnt - 1, i + 1, out + nums[i], res);
            }
        }

    }

    public class UnitTest {


    }
}
