package fraction_to_recurring_decimal;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class FractiontoRecurringDecimal {

    public class Solution {

        public String fractionToDecimal(int numerator, int denominator) {
            int s1 = numerator >= 0 ? 1 : -1;
            int s2 = denominator >= 0 ? 1 : -1;
            long num = Math.abs((long)numerator);
            long den = Math.abs((long)denominator);
            long out = num / den;
            long rem = num % den;
            Map<Long, Integer> m = new HashMap<>();
            String res = Long.toString(out);
            if (s1 * s2 == -1 && (out > 0 || rem > 0)) res = "-" + res;
            if (rem == 0) return res;
            res += ".";
            StringBuilder s = new StringBuilder("");
            int pos = 0;
            while (rem != 0) {
                if (m.containsKey(rem)) {
                    s.insert(m.get(rem), "(");
                    s.append(")");
                    return res + s;
                }
                m.put(rem, pos);
                s.append(Long.toString((rem * 10) / den));
                rem = (rem * 10) % den;
                ++pos;
            }
            return res + s;
        }
    }

    public static class UnitTest {

        @Test
        public void testFractionToDecimal() {
            Solution s = new FractiontoRecurringDecimal().new Solution();
            assertEquals("3.(3)", s.fractionToDecimal(10, 3));
            assertEquals("0.75", s.fractionToDecimal(3, 4));
            assertEquals("0.(09)", s.fractionToDecimal(1, 11));
            assertEquals("0.0000000004656612873077392578125", s.fractionToDecimal(-1, -2147483648));
        }
    }
}

