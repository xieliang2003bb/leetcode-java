package basic_calculator;

import java.util.Stack;

/**
 * Created by lxie on 2/14/18.
 */
public class BasicCalculator {

    public class Solution {

        int calculate(String s) {
            int res = 0;
            Stack<Integer> sign = new Stack<>();
            sign.push(1); sign.push(1);
            char[] str = s.toCharArray();
            for (int i = 0; i < s.length(); ++i) {
                char c = str[i];
                if (c >= '0') {
                    int num = 0;
                    while (i < s.length() && str[i] >= '0') {
                        num = 10 * num + str[i++] - '0';
                    }
                    res += sign.peek() * num;
                    sign.pop();
                    --i;
                }
                else if (c == ')') sign.pop();
                else if (c != ' ') sign.push(sign.peek() * (c == '-' ? -1 : 1));
            }
            return res;
        }
    }

    public static class UnitTest {

    }
}
