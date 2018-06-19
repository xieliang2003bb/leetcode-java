package word_pattern;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lxie on 6/18/18.
 */
public class WordPattern {

    public static class Solution {

        public boolean wordPattern(String pattern, String str) {
            Map<Character, Integer> m1 = new HashMap<>();
            Map<String, Integer> m2 = new HashMap<>();

            String[] words = str.split(" ");
            int i = 0;
            if (pattern.length() != words.length) return false;
            for (String word : words) {
                if (!m1.containsKey(pattern.charAt(i)) && !m2.containsKey(word)) {
                    m1.put(pattern.charAt(i), i);
                    m2.put(word, i);
                } else if (m1.containsKey(pattern.charAt(i)) && m2.containsKey(word)) {
                    if (m1.get(pattern.charAt(i)).intValue() != m2.get(word).intValue())
                        return false;
                } else {
                    return false;
                }
                ++i;
            }
            return i == pattern.length();
        }

        public static void main(String[] args) {
            System.out.println("this is for test");
            Solution sol = new Solution();
            System.out.println(sol.wordPattern("abba", "dog cat cat fish"));
        }
    }
}
