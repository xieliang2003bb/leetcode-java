package strobogrammatic_number_iii;

/**
 * Created by lxie on 3/16/18.
 */
public class StrobogrammaticNumberIII {

    public static class Solution {
        public int strobogrammaticInRange(String low, String high) {
            int[] res = new int[1];
            find(low, high, "", res);
            find(low, high, "0", res);
            find(low, high, "1", res);
            find(low, high, "8", res);
            return res[0];
        }

        private void find(String low, String high, String w, int[] res) {
            if (w.length() >= low.length() && w.length() <= high.length()) {
                if ((w.length() == low.length() && w.compareTo(low) < 0) ||
                        (w.length() == high.length() && w.compareTo(high) > 0)) {
                    return;
                }
                if (!(w.length() > 1 && w.toCharArray()[0] == '0')) ++res[0];
            }
            if (w.length() + 2 > high.length()) return;
            find(low, high, "0" + w + "0", res);
            find(low, high, "1" + w + "1", res);
            find(low, high, "6" + w + "9", res);
            find(low, high, "8" + w + "8", res);
            find(low, high, "9" + w + "6", res);
        }
    }

    public static void main(String[] args) {
        System.out.println("this is for test");
        Solution s = new Solution();
        System.out.println(s.strobogrammaticInRange("50", "100"));
    }
}
