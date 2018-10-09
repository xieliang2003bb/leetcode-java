package number_of_longest_increasing_subsequence;

import java.util.Arrays;

/**
 * Created by lxie on 10/9/18.
 */
public class NumberOfLIS {

    public class Solution {

        public int findNumberOfLIS(int[] nums) {
            int res = 0, mx = 0, n = nums.length;
            int[] len = new int[n]; Arrays.fill(len, 1);
            int[] cnt = new int[n]; Arrays.fill(cnt, 1);
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < i; ++j) {
                    if (nums[i] <= nums[j]) continue;
                    if (len[i] == len[j] + 1) cnt[i] += cnt[j];
                    else if (len[i] < len[j] + 1) {
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
                if (mx == len[i]) res += cnt[i];
                else if (mx < len[i]) {
                    mx = len[i];
                    res = cnt[i];
                }
            }
            return res;
        }

    }

    public class UnitTest {



    }

}
