package integer_replacement;

/**
 * Created by lxie on 11/19/17.
 */
public class IntegerReplacement {

    public static class Solution {
        public int integerReplacement(int n) {
            if (n == 1) return 0;
            if (n % 2 == 0) return 1 + integerReplacement(n / 2);
            else {
                long t = n;
                return 2 + Math.min(integerReplacement((int) ((t + 1) / 2)),
                        integerReplacement((int) ((t - 1) / 2)));
            }
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 2147483647;
        System.out.println("result is " + sol.integerReplacement(n));
    }
}
