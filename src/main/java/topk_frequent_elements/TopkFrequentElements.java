package topk_frequent_elements;

import java.util.*;

/**
 * Created by lxie on 1/10/18.
 */
public class TopkFrequentElements {

    class Solution {
        public List<Integer> topKFrequent(int[] nums, int k) {
            List<Integer> res = new ArrayList<>();
            Map<Integer, Integer> m = new HashMap<>();
            PairComparator comparator = new PairComparator();
            PriorityQueue<int[]> q = new PriorityQueue<>(100, comparator);
            for (int a : nums) {
                if (!m.containsKey(a)) m.put(a, 1);
                else
                    m.put(a, m.get(a)+1);
            };
            for (Map.Entry<Integer,Integer> entry : m.entrySet()) {
                q.add(new int[] {entry.getValue(), entry.getKey()});
            }
            while (!q.isEmpty() && k > 0) {
                res.add(q.poll()[1]);
                k--;
            }

            return res;
        }

        class PairComparator implements Comparator<int[]> {
            @Override
            public int compare(int[] p1, int[] p2) {
                return p2[0] - p1[0];  // from high to low
            }
        }
    }

    public static class UnitTest {

    }

}
