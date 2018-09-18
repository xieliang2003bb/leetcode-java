package lonely_pixel;

/**
 * Created by lxie on 9/17/18.
 */
public class LonelyPixel {

    public class Solution {

        public int findLonelyPixel(char[][] picture) {
            if (picture.length == 0  || picture[0].length == 0) return 0;
            int m = picture.length, n = picture[0].length, res = 0;
            int[] rowCnt = new int[m];
            int[] colCnt = new int[n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (picture[i][j] == 'B') {
                        ++rowCnt[i];
                        ++colCnt[j];
                    }
                }
            }
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (picture[i][j] == 'B') {
                        if (rowCnt[i] == 1 && colCnt[j] == 1) {
                            ++res;
                        }
                    }
                }
            }
            return res;
        }

    }

    public class UnitTest {


    }

}
