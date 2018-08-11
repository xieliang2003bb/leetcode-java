package sqrt_x;

public class SqrtX {

    public class Solution {

        public int SqrtX(int x) {
            long left = 0, right = (x / 2) + 1;
            while (left <= right) {
            long mid = (left + right) / 2;
            long sq = mid * mid;
                if (sq == x) return (int) mid;
                else if (sq < x) left = mid + 1;
                else right = mid - 1;
            }
            return (int) right;
        }

    }

    public static class UnitTest {

    }
}
