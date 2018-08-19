package license_key_formatting;

/**
 * Created by lxie on 8/19/18.
 */
public class LicenseKeyFormatting {

    public class Solution {
        public String licenseKeyFormatting(String S, int K) {
            StringBuilder res = new StringBuilder();
            for (int i = (int)S.length() - 1; i >= 0; --i) {
                if (S.charAt(i) != '-') {
                    ((res.length() % (K + 1) - K) != 0? res : res.append('-')).
                            append(Character.toUpperCase(S.charAt(i)));
                }
            }
            return res.reverse().toString();
        }
    }

    public class UnitTest {


    }
}
