package roman_to_integer;

import java.util.HashMap;
import java.util.Map;

public class RomantoInteger {

    public class Solution {
        private Map<Character, Integer> symbols = new HashMap<Character, Integer>();
        {
            symbols.put('M', 1000);
            symbols.put('D', 500);
            symbols.put('C', 100);
            symbols.put('L', 50);
            symbols.put('X', 10);
            symbols.put('V', 5);
            symbols.put('I', 1);
        }

        public int romanToInt(String s) {
            int num = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (i + 1 < s.length()) {
                    char nextC = s.charAt(i + 1);
                    if (symbols.get(c) < symbols.get(nextC)) {
                        num -= symbols.get(c);
                        continue;
                    }
                }
                num += symbols.get(c);
            }
            return num;
        }
    }

    public static class UnitTest {

    }
}
