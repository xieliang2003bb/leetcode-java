package word_abbreviation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lxie on 9/18/18.
 */
public class WordAbbreviation {

    public String[] wordsAbbreviation(String[] dict) {
        int n = dict.length;
        String[] res = new String[n];
        int[] pre = new int[n]; Arrays.fill(pre, 1);
        for (int i = 0; i < n; ++i) {
            res[i] = abbreviate(dict[i], pre[i]);
        }
        for (int i = 0; i < n; ++i) {
            while (true) {
                Set<Integer> s = new HashSet<>();
                for (int j = i + 1; j < n; ++j) {
                    if (res[j].equals(res[i])) s.add(j);
                }
                if (s.isEmpty()) break;
                s.add(i);
                for (int a : s) {
                    res[a] = abbreviate(dict[a], ++pre[a]);
                }
            }
        }
        return res;
    }

    private String abbreviate(String s, int k) {
        return (k >= s.length() - 2) ? s : s.substring(0, k) + Integer.toString(s.length() - k - 1) +
                s.charAt(s.length()-1);
    }


    public static void main(String[] args) {
        WordAbbreviation w = new WordAbbreviation();
        String[] dict = {"like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"};
        System.out.println(Arrays.toString(w.wordsAbbreviation(dict)));
    }
}
