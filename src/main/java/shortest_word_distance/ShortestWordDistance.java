package shortest_word_distance;

import java.util.List;

import static java.lang.StrictMath.abs;

/**
 * Created by lxie on 3/7/18.
 */
public class ShortestWordDistance {

    public class Solution {
        int shortestDistance(List<String> words, String word1, String word2) {
            int p1 = -1, p2 = -1, res = Integer.MAX_VALUE;
            for (int i = 0; i < words.size(); ++i) {
                if (words.toArray()[i] == word1) p1 = i;
                if (words.toArray()[i] == word2) p2 = i;
                if (p1 != -1 && p2 != -1) res = Math.min(res, abs(p1 - p2));
            }
            return res;
        }
    }

    public static class UnitTest {

    }

}
