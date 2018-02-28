package majority_element_ii;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxie on 2/28/18.
 */
public class MajorityElementII {

    public class Solution {
        public List<Integer> majorityElement(int[] nums) {
            List<Integer> res = new ArrayList<>();
            int m = 0, n = 0, cm = 0, cn = 0;
            for (int a : nums) { // find two majority
                if (a == m) ++cm;
                else if (a ==n) ++cn;
                else if (cm == 0) { m = a; cm = 1; }
                else if (cn == 0) { n = a; cn = 1; }
                else { --cm; --cn; }
            }
            cm = cn = 0;
            for (int a : nums) { // verify if > n/3
                if (a == m) ++cm;
                else if (a == n) ++cn;
            }
            if (cm > nums.length / 3) res.add(m);
            if (cn > nums.length / 3) res.add(n);
            return res;

        }
    }

    public static class UnitTest {

    }
}
