package jump_game;

public class JumpGame {

    public class Solution {
        public boolean canJump(int[] A) {
            int[] dp = new int[A.length];
            for (int i = 1; i < A.length; ++i) {
                dp[i] = Integer.max(dp[i - 1], A[i - 1]) - 1;
                if (dp[i] < 0) return false;
            }
            return dp[A.length - 1] >= 0;
        }
    }

    public static class UnitTest {

    }
}
