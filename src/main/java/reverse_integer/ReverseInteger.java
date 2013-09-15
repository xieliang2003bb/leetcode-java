package reverse_integer;

public class ReverseInteger {

    public class Solution {
        public int reverse(int x) {
            // Minor revision for this question: if overflow, return
            // Integer.MIN_VALUE or Integer.MAX_VALUE
            if (x == Integer.MIN_VALUE) {
                return x;
            }
            boolean overflow = false;
            boolean negative = x < 0;
            x = Math.abs(x);
            int y = 0;
            while (x != 0) {
                if (Integer.MAX_VALUE / 10 < y) {
                    overflow = true;
                    break;
                }
                y *= 10;
                int digit = x % 10;
                x /= 10;
                if (Integer.MAX_VALUE - digit < y) {
                    overflow = true;
                    break;
                }
                y += digit;
            }
            if (overflow) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            return negative ? -y : y;
        }
    }

    public static class UnitTest {

    }
}
