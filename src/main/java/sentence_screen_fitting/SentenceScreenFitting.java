package sentence_screen_fitting;

import java.util.List;

/**
 * Created by lxie on 8/19/18.
 */
public class SentenceScreenFitting {

    public class Solution {

        public int wordsTyping(List<String> sentence, int rows, int cols) {
            String all = "";
            for (String word : sentence) all += (word + " ");
            int start = 0, len = all.length();
            for (int i = 0; i < rows; ++i) {
                start += cols;
                if (all.charAt(start % len) == ' ') {
                    ++start;
                } else {
                    while (start > 0 && all.charAt(start - 1) % len != ' ') {
                        --start;
                    }
                }
            }
            return start / len;
        }
    }

    public class UnitTest {


    }
}
