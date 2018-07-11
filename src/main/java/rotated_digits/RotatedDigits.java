package rotated_digits;

/**
 * Created by lxie on 7/10/18.
 */
public class RotatedDigits {

    public class Solution {

        public int rotatedDigits(int N) {
            int res = 0;
            for (int i = 1; i <= N; ++i) {
                if (check(i)) ++res;
            }
            return res;
        }

        private boolean check(int k) {
            String str = Integer.toString(k);
            boolean flag = false;
            for (char c : str.toCharArray()) {
                if (c == '3' || c == '4' || c == '7') return false;
                if (c == '2' || c == '5' || c == '6' || c == '9') flag = true;;
            }
            return flag;
        }

    }

    public class UnitTest {



    }
}
