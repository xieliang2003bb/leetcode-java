package text_justification;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            List<String> res = new ArrayList<>();
            int i = 0;
            while (i < words.length) {
                int j = i, len = 0;
                while (j < words.length && len + words[j].length() + j - i <= maxWidth) {
                    len += words[j++].length();
                }
                String out = "";
                int space = maxWidth - len;
                for (int k = i; k < j; ++k) {
                    out += words[k];
                    if (space > 0) {
                        int tmp;
                        if (j == words.length) {
                            if (j - k == 1) tmp = space;
                            else tmp = 1;
                        } else {
                            if (j - k - 1 > 0) {
                                if (space % (j - k - 1) == 0) tmp = space / (j - k - 1);
                                else tmp = space / (j - k - 1) + 1;
                            } else tmp = space;
                        }
                        //Strings.padEnd(out, tmp, ' ');
                        for(int a=0; a<tmp; ++a) out += ' ';
                        space -= tmp;
                    }
                }
                res.add(out);
                i = j;
            }
            return res;
        }
    }

    public class UnitTest {

    }
}
