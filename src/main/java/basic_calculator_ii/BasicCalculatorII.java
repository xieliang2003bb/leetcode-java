package basic_calculator_ii;

import java.util.Stack;

/**
 * Created by lxie on 2/21/18.
 */
public class BasicCalculatorII {

    public class Solution {
        public int calculate(String s) {
            int res = 0, d = 0;
            char sign = '+';
            char[] str = s.toCharArray();
            Stack<Integer> nums = new Stack<>();
            for (int i = 0; i < s.length(); ++i) {
                if (str[i] >= '0') {
                    d = d * 10 + str[i] - '0';
                }
                if ((str[i] < '0' && str[i] != ' ') || i == s.length() - 1) {
                    if (sign == '+') nums.push(d);
                    if (sign == '-') nums.push(-d);
                    if (sign == '*' || sign == '/') {
                        int tmp = sign == '*' ? nums.peek() * d : nums.peek() / d;
                        nums.pop();
                        nums.push(tmp);
                    }
                    sign = str[i]; // operator before number
                    d = 0;
                }
            }
            while (!nums.empty()) {
                res += nums.peek();
                nums.pop();
            }
            return res;

        }
    }

    public static class UnitTest {

    }

}
