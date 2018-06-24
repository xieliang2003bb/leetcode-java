package remove_invalid_parentheses;

import java.util.*;

/**
 * Created by lxie on 6/23/18.
 */
public class RemoveInvalidParentheses {

    public class Solution {

        public List<String> removeInvalidParentheses(String s) {
            List<String> res = new ArrayList<>();
            Set<String> visited = new HashSet<>();
            Queue<String> q = new LinkedList<>();
            q.add(s);
            boolean found = false;
            while (!q.isEmpty()) {
                String t = q.peek(); q.poll();
                if (isValid(t)) {
                    res.add(t);
                    found = true;
                }
                if (found) continue;
                for (int i = 0; i < t.length(); ++i) {
                    if (t.charAt(i) != '(' && t.charAt(i) != ')') continue;
                    String str = t.substring(0, i) + t.substring(i + 1);
                    if (!visited.contains(str)) {
                        q.add(str);
                        visited.add(str);
                    }
                }
            }
            return res;
        }

        boolean isValid(String t) {
            int cnt = 0;
            for (int i = 0; i < t.length(); ++i) {
                if (t.charAt(i) == '(') ++cnt;
                else if (t.charAt(i) == ')' && --cnt < 0) return false;
            }
            return cnt == 0;
        }

    }

    public class UnitTest {

    }


}
