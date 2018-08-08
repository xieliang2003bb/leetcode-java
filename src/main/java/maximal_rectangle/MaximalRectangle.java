package maximal_rectangle;

import java.util.Stack;

public class MaximalRectangle {

    public static class Solution {
        public int maximalRectangle(char[][] matrix) {
            int res = 0;
            int[] height = new int[matrix[0].length + 1];
            for (int i = 0; i < matrix.length; ++i) {
                for (int j = 0; j < matrix[i].length; ++j) {
                    height[j] = matrix[i][j] == '0' ? 0 : (1 + height[j]);
                }
                res = Math.max(res, largestRectangleArea(height));  // LC 84
            }
            return res;
        }

        // LC 84
        private int largestRectangleArea(int[] height) {
            int res = 0;
            Stack<Integer> s = new Stack();
            height[height.length-1] = 0;
            for (int i = 0; i < height.length; ++i) {
                if (s.empty() || height[s.peek()] <= height[i]) s.push(i);
                else {
                    int tmp = s.peek();
                    s.pop();
                    res = Math.max(res, height[tmp] * (s.empty() ? i : (i - s.peek() - 1)));
                    --i;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(sol.maximalRectangle(matrix));

    }
}
