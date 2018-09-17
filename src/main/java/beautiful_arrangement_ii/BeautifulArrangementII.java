package beautiful_arrangement_ii;

/**
 * Created by lxie on 9/17/18.
 */
public class BeautifulArrangementII {

    public class Solution {

        public int[] constructArray(int n, int k) {
            int[] res = new int[n];
            int i = 1, j = n, t = 0;
            while (i <= j) {
                if (k > 1) res[t++] = (k-- % 2 != 0? i++ : j--);
                else res[t++] = (i++);
            }
            return res;
        }


    }

    public class UnitTest {


    }
}
