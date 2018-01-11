package intersection_of_two_arrays;

import com.google.common.primitives.Ints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lxie on 1/11/18.
 */
public class IntersectionOfTwoArrays {

    public class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            List<Integer> res = new ArrayList<>();
            Arrays.sort(nums1); Arrays.sort(nums2);

            int i = 0, j = 0;
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) ++i;
                else if (nums1[i] > nums2[j]) ++j;
                else {
                    if (res.size() == 0 || res.get(res.size()-1) != nums1[i]) {
                        res.add(nums1[i]);
                    }
                    ++i; ++j;
                }
            }
            return Ints.toArray(res);
        }

    }

    public static class UnitTest {



    }
}
