package find_anagram_mappings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lxie on 7/4/18.
 */
public class FindAnagramMappings {

    public static class Solution {

        public List<Integer> anagramMappings(int[] A, int[] B) {
            List<Integer> res = new ArrayList<>();
            Map<Integer, Integer> m = new HashMap<>();
            for (int i = 0; i < B.length; ++i) {
                m.put(B[i], i);
            }
            for (int num : A) res.add(m.get(num));
            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] a = {12, 28, 46, 32, 50};
        int[] b = {50, 12, 32, 46, 28};
        System.out.println("result is " + sol.anagramMappings(a, b));
    }
}
