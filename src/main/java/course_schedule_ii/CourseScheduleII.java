package course_schedule_ii;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by lxie on 2/6/18.
 */
public class CourseScheduleII {

    public class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            List<Integer> res = new ArrayList<>();
            List<List<Integer>> graph = new ArrayList<>();
            for (int i=0; i<numCourses; ++i)
                graph.add(new ArrayList<Integer>());
            int[] in = new int[numCourses];
            for (int[] a : prerequisites) {
                graph.get(a[1]).add(a[0]);
                ++in[a[0]];
            }
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < numCourses; ++i) {
                if (in[i] == 0) q.add(i);
            }
            while (q.isEmpty() == false) {
                int t = q.peek();
                res.add(t);  // get result
                q.poll();
                for (int a : graph.get(t)) {
                    --in[a];
                    if (in[a] == 0) q.add(a);
                }
            }
            if (res.size() != numCourses) res.clear(); // clear if cannot finish
            return res.stream().mapToInt(i->i).toArray();

        }

    }

    public static class UnitTest {



    }

}
