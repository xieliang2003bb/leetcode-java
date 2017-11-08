package word_ladder;

import java.util.*;

public class WordLadder {

    public static class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (!wordList.contains(endWord)) return 0;
            Map<String, Integer> m = new HashMap<>();
            Queue<String> q = new LinkedList<>();
            m.put(beginWord, 1);
            q.add(beginWord);
            while (!q.isEmpty()) {
                String word = q.remove();
                for (int i = 0; i < word.length(); ++i) {
                    String newWord = word;
                    for (char ch = 'a'; ch <= 'z'; ++ch) {
                        newWord = newWord.substring(0, i) + ch + newWord.substring(i + 1);
                        if (newWord.compareTo(endWord) == 0) return m.get(word) + 1;
                        if (wordList.contains(newWord) && !m.containsKey(newWord)) {
                            q.add(newWord);
                            m.put(newWord, m.get(word) + 1);
                        }
                    }
                }
            }
            return 0;
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<String> dict = new ArrayList<String>(
                Arrays.asList("hot","dot","dog","lot","log", "cog"));
        int ret = sol.ladderLength("hit", "cog", dict);
        System.out.println("test result is " + ret);

    }


}
