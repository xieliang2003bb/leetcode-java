package longest_word_in_dict_through_deleting;

import java.util.List;

/**
 * Created by lxie on 8/21/18.
 */
public class LongestWordDeleting {

    public class Solution {
        public String findLongestWord(String s, List<String> d) {
            String res = "";
            for (String str : d) {
                int i = 0;
                for (char c : s.toCharArray()) {
                    if (i < str.length() && c == str.charAt(i)) ++i;
                }
                if (i == str.length() && str.length() >= res.length()) {
                    if (str.length() > res.length() || str.compareTo(res) < 0) {
                        res = str;
                    }
                }
            }
            return res;
        }
    }

    public class UnitTest {


    }
}
