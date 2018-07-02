package super_ugly_number;

/**
 * Created by lxie on 7/2/18.
 */
public class SuperUglyNumber {

    public class Solution {

        public int nthSuperUglyNumber(int n, int[] primes) {
            int[] dp = new int[n]; for (int i=0; i<n; ++i) dp[i] = 1;
            int[] idx = new int[primes.length];
            for (int i = 1; i < n; ++i) {
                dp[i] = Integer.MAX_VALUE;
                for (int j = 0; j < primes.length; ++j) {
                    dp[i] = Math.min(dp[i], dp[idx[j]] * primes[j]);
                }
                for (int j = 0; j < primes.length; ++j) {
                    if (dp[i] == dp[idx[j]] * primes[j]) {
                        ++idx[j];
                    }
                }
            }
            return dp[n-1];
        }

    }

    public class UnitTest {

    }


}
