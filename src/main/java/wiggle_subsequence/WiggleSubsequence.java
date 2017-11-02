package wiggle_subsequence;

/**
 * Created by lxie on 11/2/17.
 */
public class WiggleSubsequence {

    public class Solution {

        public int wiggleMaxLength(int[] nums) {
            int n = nums.length;
            if (n == 0) return 0;


            int[] p = new int[n];
            int[] q = new int[n];
            for (int i = 0; i < n; ++i) {
                p[i] = q[i] = 1;
            }

            for (int i = 1; i < n; ++i) {
                for (int j = 0; j < i; ++j) {
                    if (nums[i] > nums[j]) p[i] = Math.max(p[i], q[j] + 1);
                    else if (nums[i] < nums[j]) q[i] = Math.max(q[i], p[j] + 1);
                }
            }
            return Math.max(p[n-1], q[n-1]);
        }
    }

    public static class UnitTest {

    }


}
