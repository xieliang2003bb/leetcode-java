package lonely_pixel_ii;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lxie on 9/17/18.
 */
public class LonelyPixelII {

    public class Solution {

        public int findBlackPixel(char[][] picture, int N) {
            if (picture.length != 0 || picture[0].length != 0) return 0;
            int m = picture.length, n = picture[0].length, res = 0;
            int[] colCnt = new int[n];
            Map<String, Integer> u = new HashMap<>();
            for (int i = 0; i < m; ++i) {
                int cnt = 0;
                for (int j = 0; j < n; ++j) {
                    if (picture[i][j] == 'B') {
                        ++colCnt[j];
                        ++cnt;
                    }
                }
                if (cnt == N) {
                    String line = new String(picture[i]);
                    if (u.containsKey(line)) {
                        u.put(line, u.get(line)+1);
                    } else {
                        u.put(line, 1);
                    }
                }
            }
            for (Map.Entry<String, Integer> a : u.entrySet()) {
                if (a.getValue() != N) continue;
                for (int i = 0; i < n; ++i) {
                    res += (a.getKey().charAt(i) == 'B' && colCnt[i] == N) ? N : 0;
                }
            }
            return res;
        }

    }

    public class UnitTest {

    }
}
