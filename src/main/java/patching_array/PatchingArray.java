package patching_array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lxie on 9/15/18.
 */
public class PatchingArray {

    public class Solution {

        public int minPatches(int[] nums, int n) {
            long miss = 1, k = nums.length;
            long[] longArray = Arrays.stream(nums).mapToLong(i -> i).toArray();
            List<Long> nums1 = Arrays.stream(longArray).boxed().collect(Collectors.toList()) ;
            int i = 0;
            while (miss <= n) {
                if (i >= nums1.size() || nums1.get(i) > miss) {
                    nums1.add(i, miss);
                }
                miss += nums1.get(i++);
            }
            return (int) (nums1.size() - k);
        }
    }

    public class UnitTest {

    }

}
