package brick_wall;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lxie on 10/1/18.
 */
public class BrickWall {

    public class Solution {

        public int leastBricks(int[][] wall) {
            int mx = 0;
            Map<Integer, Integer> m = new HashMap<>();
            for (int[] a : wall) {
                int sum = 0;
                for (int i = 0; i < a.length - 1; ++i) {
                    sum += a[i];
                    if (m.containsKey(sum))
                        m.put(sum, m.get(sum)+1);
                    else
                        m.put(sum, 1);
                    mx = Math.max(mx, m.get(sum));
                }
            }
            return wall.length - mx;
        }
    }

    public class UnitTest {



    }

}
