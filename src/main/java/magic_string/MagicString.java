package magic_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lxie on 9/10/18.
 */
public class MagicString {

    public class Solution {

        public int magicalString(int n) {
            if (n <= 0) return 0;
            if (n <= 3) return 1;
            int res = 1, head = 2, tail = 3, num = 1;
            List<Integer> v = new ArrayList<>(Arrays.asList(1, 2, 2));
            while (tail < n) {
                for (int i = 0; i < v.get(head); ++i) {
                    v.add(num);
                    if (num == 1 && tail < n) ++res;
                    ++tail;
                }
                num ^= 3;
                ++head;
            }
            return res;
        }

    }

    public class UnitTest {

    }
}
