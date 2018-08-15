package letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {

    public class Solution {

        private final String[] dict = new String[] { " ", // 0
                "", // 1
                "abc", // 2
                "def", // 3
                "ghi", // 4
                "jkl", // 5
                "mno", // 6
                "pqrs", // 7
                "tuv", // 8
                "wxyz" // 9
        };

        public List<String> letterCombinations(String digits) {
            List<String> res = new ArrayList<>();
            if (digits.isEmpty()) return res;
            letterCombinationsDFS(digits, dict, 0, "", res);
            return res;
        }

        private void letterCombinationsDFS(String digits, String[] dict, int level, String out, List<String> res) {
            if (level == digits.length()) res.add(out);
            else {
                String str = dict[digits.charAt(level) - '0'];
                for (int i = 0; i < str.length(); ++i) {
                    letterCombinationsDFS(digits, dict, level + 1, out + str.charAt(i), res);
                }
            }
        }

    }

    public static class UnitTest {

    }
}
