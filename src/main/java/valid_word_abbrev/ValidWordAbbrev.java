package valid_word_abbrev;

/**
 * Created by lxie on 9/5/18.
 */
public class ValidWordAbbrev {

    public class Solution {

        public boolean validWordAbbreviation(String word, String abbr) {
            int i = 0, j = 0, m = word.length(), n = abbr.length();
            while (i < m && j < n) {
                if (abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                    if (abbr.charAt(j) == '0') return false;
                    int val = 0;
                    while (j < n && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                        val = val * 10 + abbr.charAt(j++) - '0';
                    }
                    i += val;
                } else {
                    if (word.charAt(i++) != abbr.charAt(j++)) return false;
                }
            }
            return i == m && j == n;
        }
    }

    public class UnitTest {

    }

}
