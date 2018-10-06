package brick_wall;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lxie on 10/1/18.
 */
public class BrickWall {

    public class Solution {

        public int leastBricks(List<List<Integer>> wall) {
            int mx = 0;
            Map<Integer, Integer> m = new HashMap<>();
            for (List<Integer> a : wall) {
                int sum = 0;
                for (int i = 0; i < a.size() - 1; ++i) {
                    sum += a.get(i);
                    if (m.containsKey(sum))
                        m.put(sum, m.get(sum)+1);
                    else
                        m.put(sum, 1);
                    mx = Math.max(mx, m.get(sum));
                }
            }
            return wall.size() - mx;
        }
    }

    public class UnitTest {



    }

}
