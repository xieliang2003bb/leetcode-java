package shortest_word_distance_ii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lxie on 3/7/18.
 */
public class ShortestWordDistanceII {

    private Map<String, List<Integer>> m = new HashMap<>();

    public ShortestWordDistanceII(List<String> words) {
        for (int i = 0; i < words.size(); ++i) {
            String s = words.get(i);
            if (m.containsKey(s)) m.get(s).add(i);
            else
                m.put(s, new ArrayList<Integer>(i));
        }
    }

    public int shortest(String word1, String word2) {
        int i = 0, j = 0, res = Integer.MAX_VALUE;
        int len1 = m.containsKey(word1) ? m.get(word1).size() : -1;
        int len2 = m.containsKey(word2) ? m.get(word2).size() : -1;
        if (len1 <= 0 || len2 <= 0) return -1;

        while (i < len1 && j < len2) {
            res = Math.min(res, Math.abs(m.get(word1).get(i) - m.get(word2).get(j)));
            if (m.get(word1).get(i) < m.get(word2).get(j)) ++i;
            else ++j;
        }
        return res;
    }
}
