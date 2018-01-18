package jump_game_ii;

public class JumpGameII {

    public class Solution {
        int jump(int A[]) {
            int res = 0, i = 0, cur = 0;
            while (cur < A.length - 1) {
                int pre = cur;
                while (i <= pre) {
                    cur = Integer.max(cur, i + A[i]);
                    ++i;
                }
                ++res;
                if (pre == cur) return -1; // May not need this
            }
            return res;
        }

    }

    public static class UnitTest {

    }
}
