package strobogrammatic_number;

/**
 * Created by lxie on 2/12/18.
 */
public class StrobogrammaticNumber {

    public class Solution {

        boolean isStrobogrammatic(String num) {
            char[] numi = num.toCharArray();
            int l = 0, r = numi.length - 1;
            while (l <= r) {
                if (numi[l] == numi[r]) {
                    if (numi[l] != '1' && numi[l] != '0' && numi[l] != '8'){
                        return false;
                    }
                } else {
                    // must be 6 o 9 if not equal
                    if ((numi[l] != '6' || numi[r] != '9') && (numi[l] != '9' || numi[r] != '6')) {
                        return false;
                    }
                }
                ++l; --r;
            }
            return true;
        }



    }

    public static class UnitTest {

    }

}
