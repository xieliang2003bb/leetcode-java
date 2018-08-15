package string_to_integer_atoi;

public class StringtoIntegeratoi {

    public class Solution {

        public int atoi(String str) {
            if (str.isEmpty()) return 0;
            int sign = 1, base = 0, i = 0, n = str.length();
            while (i < n && str.charAt(i) == ' ') ++i;
            if (str.charAt(i) == '+' || str.charAt(i) == '-') {
                sign = (str.charAt(i++) == '+') ? 1 : -1;
            }
            while (i < n && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 &&
                        str.charAt(i) - '0' > 7)) {
                    return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                base = 10 * base + (str.charAt(i++) - '0');
            }
            return base * sign;

        }
    }

    public static class UnitTest {

    }
}
