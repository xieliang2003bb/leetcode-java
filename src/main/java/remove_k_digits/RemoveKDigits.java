package remove_k_digits;

/**
 * Created by lxie on 9/1/18.
 */
public class RemoveKDigits {

    public class Solution {

        public String removeKdigits(String num, int k) {
            String res = "";
            int n = num.length(), keep = n - k;
            for (char c : num.toCharArray()) {
                while (k != 0 && res.length() != 0 && res.charAt(res.length()-1) > c) {
                    res = res.substring(0, res.length()-1);
                    --k; // remove at most k numbers
                }
                res += c;
            }
            res = res.substring(0, keep);
            while (res.length() != 0 && res.charAt(0) == '0') res = res.substring(1);
            return res.isEmpty() ? "0" : res;
        }

    }

    public class UnitTest {

    }


}
