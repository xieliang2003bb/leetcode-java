package pow_x_n;

public class Powxn {

    public class Solution {
        public double myPow(double x, int n) {
            if (n < 0) return 1 / power(x, -n);
            return power(x, n);
        }

        private double power(double x, int n) {
            if (n == 0) return 1;
            double half = power(x, n / 2);
            if (n % 2 == 0) return half * half;
            return x * half * half;
        }

    }

    public static class UnitTest {

    }
}
