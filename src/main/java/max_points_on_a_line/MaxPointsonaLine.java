package max_points_on_a_line;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MaxPointsonaLine {

    public class Solution {

        public int maxPoints(Point[] points) {
            int res = 0;
            Map<Float, Integer> m = new HashMap<Float, Integer>();
            for (int i = 0; i < points.length; ++i) {
                m.clear();
                m.put((float) Integer.MIN_VALUE, 0);
                int duplicate = 1;
                for (int j = 0; j < points.length; ++j) {
                    if (j == i) continue;
                    if (points[i].x == points[j].x && points[i].y == points[j].y) {
                        ++duplicate;
                        continue;
                    }
                    float slope = (points[i].x == points[j].x) ? (float) Integer.MAX_VALUE
                        : (float) (points[j].y - points[i].y) / (points[j].x - points[i].x);
                    if (m.containsKey(slope)) {
                        m.put(slope, m.get(slope) + 1);
                    } else {
                        m.put(slope, 1);
                    }
                }
                for (Map.Entry<Float, Integer> entry : m.entrySet()) {
                    res = Math.max(res, entry.getValue() + duplicate);
                }
            }
            return res;
        }
    }

    public static class UnitTest {

    }
}
