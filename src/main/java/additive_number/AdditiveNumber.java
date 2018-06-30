package additive_number;

/**
 * Created by lxie on 6/30/18.
 */
public class AdditiveNumber {

    public static class Solution {

        public boolean isAdditiveNumber(String num) {
            for (int i = 1; i < num.length(); ++i) {
                for (int j = i + 1; j < num.length(); ++j) {
                    String s1 = num.substring(0, i);
                    String s2 = num.substring(i, j);
                long d1 = Long.parseLong(s1), d2 = Long.parseLong(s2);
                    if ((s1.length() > 1 && s1.charAt(0) == '0') ||
                            (s2.length() > 1 && s2.charAt(0) == '0')) continue;
                long next = d1 + d2;
                    String nexts = Long.toString(next);
                    String now = s1 + s2 + nexts;
                    while (now.length() < num.length()) {
                        d1 = d2;
                        d2 = next;
                        next = d1 + d2;
                        nexts = Long.toString(next);
                        now += nexts;
                    }
                    if (now.compareTo(num) == 0) return true;
                }
            }
            return false;
        }

    }

    public static void main(String[] args) {

        Solution sol = new Solution();
        boolean res = sol.isAdditiveNumber("112358");

        System.out.println("result is " + res);



    }

}
