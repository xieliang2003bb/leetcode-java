package decode_ways_ii;

/**
 * Created by lxie on 9/29/18.
 */
public class DecodeWaysII {

    public class Solution {

        public int numDecodings(String s) {
            long e0 = 1, e1 = 0, e2 = 0, f0 = 0;
            double M = 1e9 + 7;
            for (char c : s.toCharArray()) {
                if (c == '*') {
                    f0 = 9 * e0 + 9 * e1 + 6 * e2;
                    e1 = e0;
                    e2 = e0;
                } else {
                    f0 = (c > '0'? 1 : 0) * e0 + e1 + (c <= '6'? 1 : 0) * e2;
                    e1 = (c == '1'? 1 : 0) * e0;
                    e2 = (c == '2'? 1: 0) * e0;
                }
                e0 = f0 % (long)M;
            }
            return (int) e0;
        }
    }

    public class UnitTest {


    }


}
