package daily_temperature;

import java.util.Stack;

/**
 * Created by lxie on 7/24/18.
 */
public class DailyTemperature {

    public class Solution {

        public int[] dailyTemperatures(int[] temperatures) {
            int n = temperatures.length;
            int[] res = new int[n];
            Stack<Integer> st = new Stack<>();
            for (int i = 0; i < temperatures.length; ++i) {
                while (!st.empty() && temperatures[i] > temperatures[st.peek()]) {
                    int t = st.peek(); st.pop();
                    res[t] = i - t;
                }
                st.push(i);
            }
            return res;
        }

    }

    public class UnitTest {
        
    }
}
