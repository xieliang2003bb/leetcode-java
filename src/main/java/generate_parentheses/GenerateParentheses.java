package generate_parentheses;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<String>();
            helper(n, n, "", res);
            return res;
        }
        void helper(int left, int right, String out, List<String> res) {
            if (left < 0 || right < 0 || left > right) return;
            if (left == 0 && right == 0) {
                res.add(out);
                return;
            }
            helper(left - 1, right, out + "(", res);
            helper(left, right - 1, out + ")", res);
        }
    }

    public static class UnitTest {

    }
}
