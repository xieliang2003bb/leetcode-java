package find_celebrity;

/**
 * Created by lxie on 6/14/18.
 */
public class FindCelebrity {

    public class Solution {

        private boolean knows(int a, int b) {
            // ...
            return true;
        }

        public int findCelebrity(int n) {
            int res = 0;
            for (int i = 0; i < n; ++i) {
                if (knows(res, i)) res = i; // get a candidate
            }
            for (int i = 0; i < n; ++i) {
                if (res != i && (knows(res, i) || !knows(i, res))) return -1;
            }
            return res;
        }
    }

    public class UnitTest {

    }
}
