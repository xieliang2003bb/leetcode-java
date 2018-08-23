package flip_game_ii;

/**
 * Created by lxie on 6/20/18.
 */
public class FlipGameII {

    public class Solution {

        public boolean canWin(String s) {
            for (int i = 1; i < s.length(); ++i) {
                if (s.charAt(i) == '+' && s.charAt(i-1) == '+' &&
                        !canWin(s.substring(0, i-1) + "--" + s.substring(i + 1))) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {

    }
}
