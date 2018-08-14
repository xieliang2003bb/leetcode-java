package divide_two_integers;

import org.junit.Test;

public class DivideTwoIntegers {

    public class Solution {
        public int divide(int dividend, int divisor) {
            long m = Math.abs((long)dividend), n = Math.abs((long)divisor), res = 0;
                if (m < n) return 0;
                while (m >= n) {
                    long t = n, p = 1;
                    while (m > (t << 1)) {
                        t <<= 1;
                        p <<= 1;
                    }
                    res += p;
                    m -= t;
                }
                if ((dividend < 0) ^ (divisor < 0)) res = -res;
                return (int) (res > Integer.MAX_VALUE ? Integer.MAX_VALUE : res);  // -INT_MIN could be invalid
            }

        }

    public static class UnitTest {
        @Test
        public void testDivideWithOverflow() {
            Solution s = new DivideTwoIntegers().new Solution();
            System.out.println(s.divide(-2147483648, -1));

            //assertEquals(Integer.MIN_VALUE, s.divide(Integer.MIN_VALUE, 1));
        }
    }
}
