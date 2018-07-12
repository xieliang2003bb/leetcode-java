package number_of_boomerangs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lxie on 7/12/18.
 */
public class NumberOfBoomerangs {

    public class Solution {
        public int numberOfBoomerangs(int[][] points) {
            int res = 0;
            for (int i = 0; i < points.length; ++i) {
                Map<Integer, Integer> m = new HashMap<>();
                for (int j = 0; j < points.length; ++j) {
                    int a = points[i][0] - points[j][0];
                    int b = points[i][1] - points[j][1];
                    if (!m.containsKey(a * a + b * b)) {
                        m.put(a * a + b * b, 1);
                    } else {
                        m.put(a * a + b * b, m.get(a * a + b * b)+1);
                    }
                }
                for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
                    res += entry.getValue() * (entry.getValue() - 1);
                }
            }
            return res;
        }


    }

    public class UnitTest {


    }
}
