package happy_number;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lxie on 8/17/18.
 */
public class HappyNumber {

    public class Solution {
        boolean isHappy(int n) {
            Set<Integer> s = new HashSet<>();
            while (n != 1) {
                int t = 0;
                while (n != 0) {
                    t += (n % 10) * (n % 10);
                    n /= 10;
                }
                n = t;
                if (s.contains(n)) break;
                else s.add(n);
            }
            return n == 1;
        }
    }

    public class UnitTest {

    }
}
