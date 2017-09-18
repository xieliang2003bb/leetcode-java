package frog_jump;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by lxie on 9/14/17.
 */
public class FrogJump {

    class Solution {

        public boolean canCross(int[] stones) {
            HashMap<Integer, Boolean> m = new HashMap<>();
            return helper(stones, 0, 0, m);
        }

        public boolean helper(int[] stones, int pos, int jump, HashMap<Integer, Boolean> m) {
            int n = stones.length, key = pos | jump << 11;  // 11 means a big left shift
            if (pos >= n - 1) return true;
            if (m.containsKey(key)) return m.get(key);
            for (int i = pos + 1; i < n; ++i) {
                int dist = stones[i] - stones[pos];
                if (dist < jump - 1) continue;
                if (dist > jump + 1) {
                    m.put(key, false);
                    return false;
                }
                if (helper(stones, i, dist, m)) {
                    m.put(key, true);
                    return true;
                }
            }
            m.put(key, false);
            return false;
        }

        public boolean canCrossDP(int[] stones) {
            HashMap<Integer, HashSet<Integer>> dp =
                    new HashMap<Integer, HashSet<Integer>>(stones.length);
            for (int i = 0; i < stones.length; i++) {
                dp.put(stones[i], new HashSet<Integer>() );
            }
            dp.get(0).add(0);

            for (int i = 0; i < stones.length - 1; ++i) {
                int stone = stones[i];
                for (int k : dp.get(stone)) {
                    // k - 1
                    if (k - 1 > 0 && dp.containsKey(stone + k - 1))
                        dp.get(stone + k - 1).add(k - 1);
                    // k
                    if (dp.containsKey(stone + k))
                        dp.get(stone + k).add(k);
                    // k + 1
                    if (dp.containsKey(stone + k + 1))
                        dp.get(stone + k + 1).add(k + 1);
                }
            }

            return !dp.get(stones[stones.length - 1]).isEmpty();
        }

    }


    public static void main(String[] args) {
        System.out.println("this is for test");
    }


}