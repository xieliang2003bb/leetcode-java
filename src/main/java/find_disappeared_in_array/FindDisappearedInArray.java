package find_disappeared_in_array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxie on 7/10/18.
 */
public class FindDisappearedInArray {

    public class Solution {

        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] != nums[nums[i] - 1]) {
                    // swap in right order
                    int temp = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = temp;

                    --i;
                }
            }
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] != i + 1) {
                    res.add(i + 1);
                }
            }
            return res;
        }

    }

    public class UnitTest {



    }

}
