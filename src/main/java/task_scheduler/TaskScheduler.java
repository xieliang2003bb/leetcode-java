package task_scheduler;

import java.util.*;

/**
 * Created by lxie on 9/24/18.
 */
public class TaskScheduler {

    public class Solution {

        public int leastInterval(char[] tasks, int n) {
            int res = 0, cycle = n + 1;
            Map<Character, Integer> m = new HashMap<>();
            PriorityQueue<Integer> q = new PriorityQueue<>(100, Collections.reverseOrder());
            for (char c : tasks) {
                if (m.containsKey(c))
                    m.put(c, m.get(c)+1);
                else
                    m.put(c, 1);
            }
            for (Map.Entry<Character, Integer> a : m.entrySet())
                q.add(a.getValue());
            while (!q.isEmpty()) {
                int cnt = 0;
                List<Integer> t = new ArrayList<>();
                for (int i = 0; i < cycle; ++i) {
                    if (!q.isEmpty()) {
                        t.add(q.peek()); q.poll();
                        ++cnt;
                    }
                }
                for (int d : t) {
                    if (--d > 0) q.add(d);
                }
                res += q.isEmpty() ? cnt : cycle;
            }
            return res;
        }
    }

    public class UnitTest {


    }

}
