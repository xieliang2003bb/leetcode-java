package longest_valid_parentheses;

import java.util.Stack;

import static java.lang.Math.max;

public class LongestValidParentheses {

    public class Solution {
        public int longestValidParentheses(String s) {
                int res = 0, start = 0;
                Stack<Integer> m = new Stack<>();
                for (int i = 0; i < s.length(); ++i) {
                    if (s.charAt(i) == '(') m.push(i);
                    else if (s.charAt(i) == ')') {
                        if (m.empty()) start = i + 1;
                        else {
                            m.pop();
                            res = m.empty() ? max(res, i - start + 1) : max(res, i - m.peek());
                        }
                    }
                }
                return res;
            }

        }

    public static class UnitTest {

    }
}
