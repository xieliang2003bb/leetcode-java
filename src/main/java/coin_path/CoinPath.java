package coin_path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lxie on 9/21/18.
 */
public class CoinPath {

    public class Solution {

        public List<Integer> cheapestJump(int[] A, int B) {
            List<Integer> res = new ArrayList<>();
            if (A[A.length-1] == -1) return res;
            int n = A.length;
            int[] dp = new int[n]; Arrays.fill(dp, Integer.MAX_VALUE);
            int[] pos = new int[n]; Arrays.fill(dp, -1);
            dp[n - 1] = A[n - 1];
            for (int i = n - 2; i >= 0; --i) {
                if (A[i] == -1) continue;
                for (int j = i + 1; j <= Math.min(i + B, n - 1); ++j) {
                    if (dp[j] == Integer.MAX_VALUE) continue;
                    if (A[i] + dp[j] < dp[i]) {
                        dp[i] = A[i] + dp[j];
                        pos[i] = j;
                    }
                }
            }
            if (dp[0] == Integer.MAX_VALUE) return res;
            for (int cur = 0; cur != -1; cur = pos[cur]) {
                res.add(cur + 1);
            }
            return res;
        }
    }

    public class UnitTest {



    }


}
