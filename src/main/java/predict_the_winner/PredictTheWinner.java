package predict_the_winner;

import java.util.Arrays;

/**
 * Created by lxie on 9/4/18.
 */
public class PredictTheWinner {

    public class Solution {

        public boolean PredictTheWinner(int[] nums) {
            int n = nums.length;
            int[][] dp = new int[n][n];
            for(int[] a : dp) Arrays.fill(a, -1);
            return canWin(nums, 0, n - 1, dp) >= 0;
        }

        private int canWin(int[] nums, int s, int e, int[][] dp) {
            if (dp[s][e] == -1) {
                dp[s][e] = (s == e) ? nums[s] :
                        Math.max(nums[s] - canWin(nums, s + 1, e, dp), nums[e] - canWin(nums, s, e - 1, dp));
            }
            return dp[s][e];
        }

    }

    public class UnitTest {


    }
}
