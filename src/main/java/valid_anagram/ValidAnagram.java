package valid_anagram;

/**
 * Created by lxie on 3/6/18.
 */
public class ValidAnagram {

    public class Solution {
        public boolean isAnagram(String s, String t) {
            int lens = s.length(), lent = t.length();
            if (lens != lent) return false;
            int[] m = new int[26];
            for (int i = 0; i < lens; ++i) ++m[s.toCharArray()[i] - 'a'];
            for (int i = 0; i < lent; ++i) {
                if (--m[t.toCharArray()[i] - 'a'] < 0) return false;
            }
            return true;
        }
    }

    public static class UnitTest {

    }

}
