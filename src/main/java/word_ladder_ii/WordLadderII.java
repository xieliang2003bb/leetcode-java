package word_ladder_ii;

import java.util.*;

public class WordLadderII {

    public static class Solution {

        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            List<List<String>> res = new ArrayList<>(new ArrayList<>());
            Set<String> dict = new HashSet<>(wordList);
            List<String> p = new ArrayList<>(Arrays.asList(beginWord));
            Queue<List<String>> paths = new LinkedList<>();
            paths.add(p);
            int level = 1, minLevel = Integer.MAX_VALUE;
            Set<String> words = new HashSet<>();
            while (!paths.isEmpty()) {
                List<String> t = paths.remove();
                if (t.size() > level) {   // enters a new level
                    for (String w : words) dict.remove(w);   // removes words used in the last level
                    words.clear();
                    level = t.size();
                    if (level > minLevel)
                        break;
                }
                String last = t.get(t.size() - 1);
                for (int i = 0; i < last.length(); ++i) {
                    // String newLast = last;
                    for (char ch = 'a'; ch <= 'z'; ++ch) {
                        if (last.charAt(i) == ch) continue;
                        String newLast = last.substring(0, i) + ch + last.substring(i + 1);
                        if (!dict.contains(newLast)) continue;
                        words.add(newLast);
                        List<String> nextPath = new ArrayList<>(t);
                        nextPath.add(newLast);
                        if (newLast.compareTo(endWord) == 0) {
                            res.add(nextPath);
                            minLevel = level;
                        } else {
                            paths.add(nextPath);
                        }

                    }
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<String> dict = new ArrayList<String>(
                Arrays.asList("hot","dot","dog","lot","log", "cog"));
        List<List<String>> ret = sol.findLadders("hit", "cog", dict);
        System.out.println("test result is " + ret.toString());

    }

}
