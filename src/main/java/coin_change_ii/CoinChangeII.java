package coin_change_ii;

/**
 * Created by lxie on 11/16/17.
 */
public class CoinChangeII {

    public class Solution {
        public int change(int amount, int[] coins) {
            int[] dp = new int[amount + 1];
            dp[0] = 1;
            for (int coin : coins) {
                for (int i = coin; i <= amount; ++i) {
                    dp[i] += dp[i - coin];
                }
            }
            return dp[amount];
        }

    }

    public static class UnitTest {

    }



}
