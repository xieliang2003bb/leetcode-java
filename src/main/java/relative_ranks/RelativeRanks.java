package relative_ranks;

import common.Pair;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by lxie on 7/12/18.
 */
public class RelativeRanks {

    public class Solution {

        public String[] findRelativeRanks(int[] nums) {
            int n = nums.length, cnt = 1;
            String[] res = new String[n];
            PriorityQueue<Map.Entry<Integer, Integer>> q =
                    new PriorityQueue<Map.Entry<Integer, Integer>>(10,
                    new Comparator<Map.Entry<Integer, Integer>>() {
                        @Override
                        public int compare(Map.Entry<Integer, Integer> p1, Map.Entry<Integer, Integer> p2) {
                            return p2.getKey() - p1.getKey();
                        }
                    });
            for (int i = 0; i < n; ++i) {
                q.add(Pair.of(nums[i], i));
            }
            for (int i = 0; i < n; ++i) {
                int idx = q.peek().getValue(); q.poll();
                if (cnt == 1) res[idx] = "Gold Medal";
                else if (cnt == 2) res[idx] = "Silver Medal";
                else if (cnt == 3) res[idx] = "Bronze Medal";
                else res[idx] = Integer.toString(cnt);
                ++cnt;
            }
            return res;
        }

    }

    public class UnitTest {

    }
}
