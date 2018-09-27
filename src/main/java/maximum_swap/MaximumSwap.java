package maximum_swap;

/**
 * Created by lxie on 9/27/18.
 */
public class MaximumSwap {

    public class Solution {

        public int maximumSwap(int num) {
            char[] res = Integer.toString(num).toCharArray();
            char[] back = res.clone();
            for (int i = back.length - 2; i >= 0; --i) {
                back[i] = back[i] < back[i + 1] ? back[i + 1] : back[i];
            }
            for (int i = 0; i < res.length; ++i) {
                if (res[i] == back[i]) continue;
                for (int j = res.length - 1; j > i; --j) {
                    if (res[j] == back[i]) {
                        char tmp = res[j];
                        res[j] = res[i];
                        res[i] = tmp;
                        return Integer.parseInt(new String(res));
                    }
                }
            }
            return num;
        }
    }

    public class UnitTest {


    }


}
