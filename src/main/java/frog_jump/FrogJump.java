package frog_jump;

import java.util.HashMap;

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
    }


    public static void main(String[] args) {
        System.out.println("this is for test");
    }


}
