package palindrom_pairs;

import java.util.*;

/**
 * Created by lxie on 1/23/18.
 */
public class PalindromePairs {

    public class Solution {

        public List<List<Integer>> palindromePairs(String[] words) {
            List<List<Integer>> res = new ArrayList<>();
            Map<String, Integer> m = new HashMap<String, Integer>();
            Set<Integer> s = new TreeSet<Integer>();
            for (int i = 0; i < words.length; ++i) {
                m.put(words[i], i);
                s.add(words[i].length());
            }
            for (int i = 0; i < words.length; ++i) {
                String t = words[i];
                int len = t.length();
                t = new StringBuilder(t).reverse().toString();
                if (m.containsKey(t) && m.get(t) != i) { // not self
                    res.add(Arrays.asList(i, m.get(t)));
                }

                for (int d : s) {
                    if (d >= len) break;
                    if (isValid(t, 0, len - d - 1) && m.containsKey(t.substring(len - d))) {
                        res.add(Arrays.asList(i, m.get(t.substring(len - d)))); // abcdd - cba, t is reversed
                    }
                    if (isValid(t, d, len - 1) && m.containsKey(t.substring(0, d))) {
                        res.add(Arrays.asList(m.get(t.substring(0, d)), i)); // aabcd - dcb, t is reversed
                    }
                }
            }
            return res;
        }

        private boolean isValid(String t, int left, int right) {
            while (left < right) {
                if (t.toCharArray()[left++] != t.toCharArray()[right--]) return false;
            }
            return true;
        }

    }

    public static class UnitTest {

    }

}
