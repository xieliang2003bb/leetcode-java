package ways_to_add_parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxie on 12/11/17.
 */
public class DiffWaysAddParentheses {
    public class Solution {
        public List<Integer> diffWaysToCompute(String input) {
            List<Integer> res = new ArrayList<>();
            char[] input1 = input.toCharArray();
            for (int i = 0; i < input.length(); ++i) {
                if (input1[i] == '+' || input1[i] == '-' || input1[i] == '*') {
                    List<Integer> left = diffWaysToCompute(input.substring(0, i));
                    List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                    for (int j = 0; j < left.size(); ++j) {
                        for (int k = 0; k < right.size(); ++k) {
                            if (input1[i] == '+') res.add(left.get(j) + right.get(k));
                            else if (input1[i] == '-') res.add(left.get(j) - right.get(k));
                            else res.add(left.get(j) * right.get(k));
                        }
                    }
                }
            }
            if (res.isEmpty()) res.add(Integer.parseInt(input));  // input is an integer
            return res;
        }
    }

    public static class UnitTest {

    }

}
