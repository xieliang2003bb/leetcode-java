package ugly_number_ii;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxie on 6/6/18.
 */
public class UglyNumberII {

    public class Solution {
        public int nthUglyNumber(int n) {
            List<Integer> res = new ArrayList<>();
            res.add(1);
            int i2 = 0, i3 = 0, i5 = 0;
            while (res.size() < n) {
                int m2 = res.get(i2) * 2, m3 = res.get(i3) * 3, m5 = res.get(i5) * 5;
                int mn = Integer.min(m2, Integer.min(m3, m5));
                if (mn == m2) ++i2;
                if (mn == m3) ++i3;
                if (mn == m5) ++i5;
                res.add(mn);
            }
            return res.get(res.size()-1);
        }
    }

    public class UnitTest {

    }

}
