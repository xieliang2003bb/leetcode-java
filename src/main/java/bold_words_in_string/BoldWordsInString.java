package bold_words_in_string;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lxie on 7/17/18.
 */
public class BoldWordsInString {

    public String boldWords(String[] words, String S) {
        int n = S.length();
        String res = "";
        Set<Integer> bold = new HashSet<>();
        for (String word : words) {
            int len = word.length();
            for (int i = 0; i <= n - len; ++i) {
                if (S.charAt(i) == word.charAt(0) && S.substring(i, i+len).compareTo(word) == 0) {
                    for (int j = i; j < i + len; ++j) bold.add(j);
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            if (bold.contains(i) && !bold.contains(i - 1)) res += "<b>";
            res += S.charAt(i);
            if (bold.contains(i) && !bold.contains(i + 1)) res += "</b>";
        }
        return res;
    }

    public static void main(String[] args) {
        BoldWordsInString bs = new BoldWordsInString();
        String[] words = {"ab", "bc"};
        System.out.println(bs.boldWords(words, "aabcd"));

    }
}
