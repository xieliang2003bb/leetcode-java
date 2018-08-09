package largest_rectangle_in_histogram;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class LargestRectangleinHistogram {

    public class Solution {
        public int largestRectangleArea(int[] height) {
            int res = 0;
            List<Integer> heights = Arrays.stream(height).boxed().collect(Collectors.toList());;
            heights.add(0);
            Stack<Integer> st = new Stack<>();
            for (int i = 0; i < heights.size(); ++i) {
                if (st.empty() || heights.get(st.peek()) < heights.get(i)) {
                    st.push(i);
                } else {
                    int cur = st.peek(); st.pop();
                    res = Math.max(res, heights.get(cur) * (st.empty() ? i : (i - st.peek() - 1)));
                    --i;
                }
            }
            return res;
        }
    }

    public static class UnitTest {
    }
}
