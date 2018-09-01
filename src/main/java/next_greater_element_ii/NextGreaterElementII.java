package next_greater_element_ii;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by lxie on 9/1/18.
 */
public class NextGreaterElementII {

    public class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int n = nums.length;
            int[] res = new int[n]; Arrays.fill(res, -1);
            Stack<Integer> st = new Stack<>();
            for (int i = 0; i < 2 * n; ++i) {
                int num = nums[i % n];
                while (!st.empty() && nums[st.peek()] < num) {
                    res[st.peek()] = num; st.pop();
                }
                if (i < n) st.push(i); // when i>n-1, we seek next larger for those in stack only
            }
            return res;
        }
    }

    public class UnitTest {



    }

}
