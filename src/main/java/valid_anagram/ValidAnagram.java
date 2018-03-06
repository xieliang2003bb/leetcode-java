package valid_anagram;

/**
 * Created by lxie on 3/6/18.
 */
public class ValidAnagram {

    public class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) return false;
            int[] m = new int[26];
            for (int i = 0; i < s.length(); ++i) ++m[s.toCharArray()[i] - 'a'];
            for (int i = 0; i < t.length(); ++i) {
                if (--m[t.toCharArray()[i] - 'a'] < 0) return false;
            }
            return true;
        }
    }

    public static class UnitTest {

    }

}
