package count_and_say;

public class CountandSay {

    public class Solution {
        public String countAndSay(int n) {
            if (n <= 0) return "";
            String res = "1";
            while (--n != 0) {
                String cur = "";
                for (int i = 0; i < res.length(); ++i) {
                    int cnt = 1;
                    while (i + 1 < res.length() && res.charAt(i) == res.charAt(i+1)) {
                        ++cnt;
                        ++i;
                    }
                    cur += Integer.toString(cnt) + res.charAt(i);
                }
                res = cur;
            }
            return res;
        }

    }

    public static class UnitTest {

    }
}
