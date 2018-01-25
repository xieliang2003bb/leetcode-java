package line_reflection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by lxie on 1/24/18.
 */
public class LineReflection {

    public class Solution {
        public boolean isReflected(int[][] points) {
            Map<Integer, Set<Integer>> m = new HashMap<>();
            int mx = Integer.MIN_VALUE, mn = Integer.MIN_VALUE;
            for (int[] a : points) {
                mx = Integer.max(mx, a[0]);
                mn = Integer.min(mn, a[0]);
                m.get(a[0]).add(a[1]);
            }
            double y = (double)(mx + mn) / 2;
            for (int[] a : points) {
                double t = 2 * y - a[0];
                if (!m.containsKey(t) || !m.get(t).contains(a[1])) {
                    return false;
                }
            }
            return true;
        }
    }

    public static class UnitTest {



    }


}
