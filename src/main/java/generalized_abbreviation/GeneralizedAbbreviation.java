package generalized_abbreviation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxie on 7/3/18.
 */
public class GeneralizedAbbreviation {

    public static class Solution {

        public List<String> generateAbbreviations(String word) {
            List<String> res = new ArrayList<>();
            for (int i = 0; i < Math.pow(2, word.length()); ++i) {
                String out = "";
                int cnt = 0;
                for (int j = 0; j < word.length(); ++j) {
                    if (((i >> j) & 1) == 1) ++cnt;
                    else {
                        if (cnt != 0) {
                            out += Integer.toString(cnt);
                            cnt = 0;
                        }
                        out += word.charAt(j);
                    }
                }
                if (cnt > 0) out += Integer.toString(cnt);
                res.add(out);
            }
            return res;
        }

    }

    public static void main (String[] args) {
        Solution sol = new Solution();
        System.out.println("result is " + sol.generateAbbreviations("word"));
    }
}
