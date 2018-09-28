package total_hamming_distance;

/**
 * Created by lxie on 9/28/18.
 */
public class TotalHammingDistance {

    public class Solution {

        public int totalHammingDistance(int[] nums) {
            int res = 0, n = nums.length;
            for (int i = 0; i < 32; ++i) {
                int cnt = 0;
                for (int num : nums) {
                    if ((num & (1 << i)) == 1) ++cnt;
                }
                res += cnt * (n - cnt);
            }
            return res;
        }
    }

    public class UnitTest {



    }


}
