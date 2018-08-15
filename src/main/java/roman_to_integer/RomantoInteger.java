package roman_to_integer;

import java.util.HashMap;
import java.util.Map;

public class RomantoInteger {

    public class Solution {
        private Map<Character, Integer> m = new HashMap<Character, Integer>();
        {
            m.put('M', 1000);
            m.put('D', 500);
            m.put('C', 100);
            m.put('L', 50);
            m.put('X', 10);
            m.put('V', 5);
            m.put('I', 1);
        }

        public int romanToInt(String s) {
            int res = 0;
            for (int i = 0; i < s.length(); ++i) {
                int val = m.get(s.charAt(i));
                if (i == s.length() - 1 || m.get(s.charAt(i+1)) <= m.get(s.charAt(i))) res += val;
                else res -= val;
            }
            return res;
        }
    }

    public static class UnitTest {

    }
}
