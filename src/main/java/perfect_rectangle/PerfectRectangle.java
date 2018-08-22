package perfect_rectangle;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lxie on 8/22/18.
 */
public class PerfectRectangle {

    public class Solution {
        public boolean isRectangleCover(int[][] rectangles) {
            Map<String, Integer> m = new HashMap<>();
            int min_x = Integer.MAX_VALUE, min_y = Integer.MAX_VALUE,
                    max_x = Integer.MIN_VALUE, max_y = Integer.MIN_VALUE, area = 0, cnt = 0;
            for (int[] rect : rectangles) {
                min_x = Math.min(min_x, rect[0]);
                min_y = Math.min(min_y, rect[1]);
                max_x = Math.max(max_x, rect[2]);
                max_y = Math.max(max_y, rect[3]);
                area += (rect[2] - rect[0]) * (rect[3] - rect[1]);
                if (!isValid(m, Integer.toString(rect[0]) + "_" + Integer.toString(rect[1]), 1)) return false; // bottom-left
                if (!isValid(m, Integer.toString(rect[0]) + "_" + Integer.toString(rect[3]), 2)) return false; // top-left
                if (!isValid(m, Integer.toString(rect[2]) + "_" + Integer.toString(rect[3]), 4)) return false; // top-right
                if (!isValid(m, Integer.toString(rect[2]) + "_" + Integer.toString(rect[1]), 8)) return false; // bottom-right
            }
            for (Map.Entry<String, Integer> it : m.entrySet() ) {
                int t = it.getValue();
                if (t != 15 && t != 12 && t != 10 && t != 9 && t != 6 && t != 5 && t!= 3) {
                    ++cnt;
                }
            }
            return cnt == 4 && area == (max_x - min_x) * (max_y - min_y);
        }

        private boolean isValid(Map<String, Integer> m, String corner, int type) {
            int val = 0;
            if (m.containsKey(corner)) val = m.get(corner);
            if ((val & type) != 0) return false; // cannot be same type of corner twice
            m.put(corner, val|type);
            return true;
        }


    }

    public class UnitTest {



    }

}
