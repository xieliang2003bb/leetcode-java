package longest_uncommon_subsequence_ii;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lxie on 9/20/18.
 */
public class LongestUncommonSubsequence {

    public int findLUSlength(String[] strs) {
        int n = strs.length;
        Set<String> s = new HashSet<>();
        Arrays.sort(strs, new Comparator<String>() {
                    @Override
                    public int compare(String a, String b) {
                        if (a.length() == b.length()) return b.compareTo(a);
                        return b.length() - a.length();
                    }
                });
        for (int i = 0; i < n; ++i) {
            if (i == n - 1 || strs[i] != strs[i + 1]) {
                boolean found = true;
                for (String a : s) { // compare to longer ones
                    int j = 0;
                    for (char c : a.toCharArray()) {
                        if (c == strs[i].charAt(j)) ++j;
                        if (j == strs[i].length()) break;
                    }
                    if (j == strs[i].length()) {
                        found = false;
                        break;
                    }
                }
                if (found) return strs[i].length();
            }
            s.add(strs[i]);
        }
        return -1;
    }

    public static void main(String[] args) {
        LongestUncommonSubsequence s = new LongestUncommonSubsequence();
        String[] input = {"aba", "cdc", "eae", "whatsapp"};
        System.out.println(s.findLUSlength(input));
    }
}
