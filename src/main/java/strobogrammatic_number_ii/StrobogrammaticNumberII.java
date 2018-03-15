package strobogrammatic_number_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lxie on 3/15/18.
 */
public class StrobogrammaticNumberII {

    public static class Solution {

        public List<String> findStrobogrammatic(int n) {
            return find(n, n);
        }

        private List<String> find(int m, int n) {
            if (m == 0) return new ArrayList<String>(Arrays.asList(""));
            if (m == 1) return new ArrayList<String>(Arrays.asList("0", "1", "8"));
            List<String> t = find(m - 2, n);
            List<String> res = new ArrayList<>();
            for (String a : t) {
                if (m != n) res.add("0" + a + "0"); // cannot add 0 when m = n
                res.add("1" + a + "1");
                res.add("6" + a + "9");
                res.add("8" + a + "8");
                res.add("9" + a + "6");
            }
            return res;
        }

    }

    public static void main(String[] args) {
        System.out.println("this is for test");
        Solution s = new Solution();
        System.out.println(s.findStrobogrammatic(3));
    }

}
