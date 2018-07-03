package max_product_of_word_lengths;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lxie on 7/3/18.
 */
public class MaxProdWordLenghs {

    public class Solution {

        public int maxProduct(String[] words) {
            int res = 0;
            Map<Integer, Integer> m = new HashMap<>();
            for (String word : words) {
                int mask = 0;
                for (char c : word.toCharArray()) {
                    mask |= 1 << (c - 'a');
                }
                if (!m.containsKey(mask)) {
                    m.put(mask, word.length());
                } else {
                    m.put(mask, Math.max(m.get(mask), word.length()));
                }

                for (Map.Entry<Integer, Integer> a : m.entrySet()) {
                    if ((mask & a.getKey()) == 0) {
                        res = Math.max(res, (int)word.length() * a.getValue());
                    }
                }
            }
            return res;
        }
    }

    public class UnitTest {



    }


}
