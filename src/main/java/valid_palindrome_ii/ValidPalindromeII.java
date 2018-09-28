package valid_palindrome_ii;

/**
 * Created by lxie on 9/28/18.
 */
public class ValidPalindromeII {

    public class Solution {

        public boolean validPalindrome(String s) {
            int left = 0, right = s.length() - 1;
            while (left < right) {
                if (s.charAt(left) == s.charAt(right)) {
                    ++left; --right;
                } else {
                    int l = left, r = right - 1;
                    while (l < r) {
                        if (s.charAt(l) != s.charAt(r)) break;
                        ++l; --r;
                        if (l >= r) return true;
                    }
                    ++left;
                    while (left < right) {
                        if (s.charAt(left) != s.charAt(right)) return false;
                        ++left; --right;
                    }
                }
            }
            return true;
        }


    }

    public class UnitTest {


    }


}
