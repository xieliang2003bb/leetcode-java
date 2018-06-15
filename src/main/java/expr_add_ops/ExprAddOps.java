package expr_add_ops;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxie on 6/15/18.
 */
public class ExprAddOps {

    public static class Solution {

        public List<String> addOperators(String num, int target) {
            List<String> res = new ArrayList<>();
            addOperatorsDFS(num, target, 0, 0, "", res);
            return res;
        }

        public void addOperatorsDFS(String num, int target, long diff, long curNum, String out, List<String> res) {
            if (num.length() == 0 && curNum == target) {
                res.add(out);
            }
            for (int i = 1; i <= num.length(); ++i) {
                String cur = num.substring(0, i);
                if (cur.length() > 1 && cur.charAt(0) == '0') return;
                String next = num.substring(i);
                Long curLong = Long.parseLong(cur);
                if (out.length() > 0) {
                    addOperatorsDFS(next, target, curLong, curNum + curLong, out + "+" + cur, res);
                    addOperatorsDFS(next, target, -curLong, curNum - curLong, out + "-" + cur, res);
                    addOperatorsDFS(next, target, diff * curLong, (curNum - diff) + diff * curLong, out + "*" + cur, res);
                } else {
                    addOperatorsDFS(next, target, curLong, curLong, cur, res); // first split
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("this is for test");
        Solution sol = new Solution();

        System.out.println(sol.addOperators("232", 8));

    }


}
