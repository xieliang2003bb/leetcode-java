package first_bad_version;

/**
 * Created by lxie on 12/3/17.
 */
public class FirstBadVersion {

    public static class Solution {
        public int firstBadVersion(int n) {
            int left = 1, right = n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (isBadVersion(mid)) right = mid;
                else left = mid + 1;
            }
            return left;

        }

        // stub function here
        private boolean isBadVersion(int version) {
            return false;
        }
    }

    public static class UnitTest {

    }
}
