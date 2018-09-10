package smallest_good_base;

/**
 * Created by lxie on 9/10/18.
 */
public class SmallestGoodBase {

    public class Solution {

        public String smallestGoodBase(String n) {
            long num = Long.parseLong(n);
            for (int i = (int) (Math.log(num + 1) / Math.log(2)); i >= 2; --i) {  // smallest base first: 2^m <= n
            long left = 2, right = (long) Math.pow(num, 1.0 / (i - 1)) + 1;
                while (left < right) {
                long mid = left + (right - left) / 2, sum = 0;
                    for (int j = 0; j < i; ++j) {
                        sum = sum * mid + 1;
                    }
                    if (sum == num) return Long.toString(mid);
                    else if (sum < num) left = mid + 1;
                    else right = mid;
                }
            }
            return Long.toString(num - 1);
        }
    }

    public class UnitTest {


    }

}
