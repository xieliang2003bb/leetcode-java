package valid_word_square;

/**
 * Created by lxie on 8/19/18.
 */
public class ValidWordSquare {

    public class Solution {
        public boolean validWordSquare(String[] words) {
            // Write your code here
            char[][] square = new char[words.length][words.length];

            for (int i = 0; i < words.length; i++) {
                square[i] = words[i].toCharArray();
            }

            for (int i = 0; i < square.length; i++) {
                for (int j = 0; j <= i; j++) {
                    if (square[i][j] != square[j][i]) {
                        return false;
                    }
                }
            }

            return true;
        }

    }

    public class UnitTest {


    }
}
