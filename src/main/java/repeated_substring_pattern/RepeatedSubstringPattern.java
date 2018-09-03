package repeated_substring_pattern;

/**
 * Created by lxie on 9/3/18.
 */
public class RepeatedSubstringPattern {

    public class Solution {

        public boolean repeatedSubstringPattern(String str) {
            int n = str.length();
            for (int i = n / 2; i >= 1; --i) {
                if (n % i == 0) {
                    int c = n / i;
                    String t = "";
                    for (int j = 0; j < c; ++j) {
                        t += str.substring(0, i);
                    }
                    if (t.compareTo(str) == 0) return true;
                }
            }
            return false;
        }
    }

    public class UnitTest {


    }


}
