package exclusive_time_of_functions;

import java.util.List;
import java.util.Stack;

/**
 * Created by lxie on 9/26/18.
 */
public class ExclusiveTimeOfFunctions {

    public class Solution {

        public int[] exclusiveTime(int n, List<String> logs) {
            int[] res = new int[n];
            Stack<Integer> st = new Stack<>();
            int preTime = 0;
            for (String log : logs) {
                String[] params = log.split(":");
                int idx = Integer.parseInt(params[0]);
                String type = params[1];
                int time = Integer.parseInt(params[2]);
                if (!st.empty()) {
                    res[st.peek()] += time - preTime;
                }
                preTime = time;
                if (type.equals("start")) st.push(idx);
                else {
                    int t = st.peek(); st.pop();
                    ++res[t];  // add 1s for ended task
                    ++preTime;
                }
            }
            return res;
        }

    }

    public class UnitTest {



    }


}
