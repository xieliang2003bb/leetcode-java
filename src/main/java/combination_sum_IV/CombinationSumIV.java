package combination_sum_IV;

import java.util.Arrays;

/**
 * Created by lxie on 9/14/17.
 */
public class CombinationSumIV {

    class Solution {
        public int combinationSum4(int[] nums, int target) {
            int[] dp = new int[target+1];
            dp[0] = 1;
            Arrays.sort(nums);
            for (int i = 1; i <= target; i++) {
                for(int a : nums){
                    if (i < a) break;
                    dp[i] += dp[i-a];
                }
            }
            return dp[target];
        }
    }

    public static void main(String[] args) {
        System.out.println("this is for test");
    }

}
