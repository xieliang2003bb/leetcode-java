package find_k_pairs_smallest_sum;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by lxie on 1/27/18.
 */
public class KPairsSmallestSum {

    public class Solution  {

        public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            List<int[]> res = new ArrayList<>();
            PairComparator comparator = new PairComparator();
            PriorityQueue<int[]> q = new PriorityQueue<>(100, comparator);
            for (int i = 0; i < Integer.min((int)nums1.length, k); ++i) {
                for (int j = 0; j < Integer.min((int)nums2.length, k); ++j) {
                    if (q.size() < k) {
                        q.add(new int[] {nums1[i], nums2[j]});
                    } else if (nums1[i] + nums2[j] < q.peek()[0] + q.peek()[1]) {
                        q.add(new int[]{nums1[i], nums2[j]}); q.poll();
                    }
                }
            }
            while (!q.isEmpty()) {
                res.add(q.peek()); q.poll();
            }
            return res;
        }

        class PairComparator implements Comparator<int[]> {
            @Override
            public int compare(int[] p1, int[] p2) {
                return (p2[0] + p2[1]) - (p1[0] + p1[1]);
            }
        }

    }

    public static class UnitTest {


    }

}
