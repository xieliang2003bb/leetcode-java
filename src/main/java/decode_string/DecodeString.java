package decode_string;

/**
 * Created by lxie on 8/19/18.
 */
public class DecodeString {

    public class Solution {
        public String decodeString(String s) {
            int[] i = {0};
            return decode(s, i);
        }

        private String decode(String s, int[] i) {
            String res = "";
            int n = s.length();
            while (i[0] < n && s.charAt(i[0]) != ']') {
                if (s.charAt(i[0]) < '0' || s.charAt(i[0]) > '9') {
                    res += s.charAt(i[0]++);
                } else {
                    int cnt = 0;
                    while (i[0] < n && s.charAt(i[0]) >= '0' &&
                            s.charAt(i[0]) <= '9') {
                        cnt = cnt * 10 + s.charAt(i[0]++) - '0';
                    }
                    ++i[0]; // skip '['
                    String t = decode(s, i);
                    ++i[0]; // skip ']' and continue
                    while (cnt-- > 0) {
                        res += t;
                    }
                }
            }
            return res;
        }

    }

    public class UnitTest {


    }
}
