package relative_ranks;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by lxie on 7/12/18.
 */
public class RelativeRanks {

    public class Solution {

        public String[] findRelativeRanks(int[] nums) {
            int n = nums.length, cnt = 1;
            String[] res = new String[n];
            PriorityQueue<Pair<Integer, Integer>> q =
                    new PriorityQueue<Pair<Integer, Integer>>(10,
                    new Comparator<Pair<Integer, Integer>>() {
                        @Override
                        public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                            return p2.getKey() - p1.getKey();
                        }
                    });
            for (int i = 0; i < n; ++i) {
                q.add(new Pair(nums[i], i));
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
