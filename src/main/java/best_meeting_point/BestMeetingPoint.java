package best_meeting_point;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by lxie on 6/20/18.
 */
public class BestMeetingPoint {

    public class Solution {

        public int minTotalDistance(int[][] grid) {
            List<Integer> rows = new ArrayList<Integer>();
            List<Integer> cols = new ArrayList<Integer>();
            for (int i = 0; i < grid.length; ++i) {
                for (int j = 0; j < grid[i].length; ++j) {
                    if (grid[i][j] == 1) {
                        rows.add(i);
                        cols.add(j);
                    }
                }
            }
            return minTotalDistance(rows) + minTotalDistance(cols);
        }
        int minTotalDistance(List<Integer> v) {
            int res = 0;
            Collections.sort(v);
            int i = 0, j = v.size() - 1;
            while (i < j) res += v.get(j--) - v.get(i++);
            return res;
        }

    }

    public class UnitTest {

    }

}
