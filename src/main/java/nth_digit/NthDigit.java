package nth_digit;

/**
 * Created by lxie on 8/28/18.
 */
public class NthDigit {

    public class Solution {
        int findNthDigit(int n) {
        long len = 1, cnt = 9, start = 1;
            while (n > len * cnt) {
                n -= len * cnt;
                ++len;
                cnt *= 10;
                start *= 10;
            }
            start += (n - 1) / len;
            String t = Long.toString(start);
            return t.charAt((n - 1) % (int)len) - '0';
        }
    }

    public class UnitTest {


    }
}
