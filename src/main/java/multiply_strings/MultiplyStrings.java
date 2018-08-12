package multiply_strings;

import java.util.Arrays;

public class MultiplyStrings {

    public class Solution {

        public String multiply(String num1, String num2) {
            if (num1.charAt(0) == '0' || num2.charAt(0) == '0') return "0";
            int n1 = num1.length(), n2 = num2.length(), n = (n1 + n2);
            int[] r = new int[n];
            char[] s = new char[n];
            Arrays.fill(s, '0');

            for (int i = 0; i < n1; ++i) {
                for (int j = 0; j < n2; ++j) {
                    r[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                }
            }

            for (int i = n - 1; i > 0; --i) {
                if (r[i] > 9) r[i - 1] += r[i] / 10;
                s[i] += r[i] % 10;
            }
            s[0] += r[0];
            return s[0] == '0' ? new String(s).substring(1) : new String(s);
        }
    }

    public static class UnitTest {
    }
}
