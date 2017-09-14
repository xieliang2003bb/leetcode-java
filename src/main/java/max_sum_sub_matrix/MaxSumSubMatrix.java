package max_sum_sub_matrix;

import com.google.common.collect.BoundType;
import com.google.common.collect.Multiset;
import com.google.common.collect.TreeMultiset;

import java.util.Arrays;

/**
 * Created by lxie on 9/11/17.
 */
public class MaxSumSubMatrix {

    public static class Solution {
        public int maxSumSubmatrix(int[][] matrix, int kval) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                return 0;
            }
            int m = matrix.length, n = matrix[0].length, res = Integer.MIN_VALUE;
            for (int i = 0; i < n; ++i) {
                int[] sum = new int[m];
                Arrays.fill(sum, 0);
                for (int j = i; j < n; ++j) {
                    for (int k = 0; k < m; ++k) {
                        sum[k] += matrix[k][j];
                    }
                    int curSum = 0, curMax = Integer.MIN_VALUE;
                    TreeMultiset<Integer> s = TreeMultiset.create();
                    s.add(0);
                    for(int a : sum){
                        curSum += a;
                        Multiset.Entry<Integer> it = s.tailMultiset(curSum - kval, BoundType.CLOSED).firstEntry();
                        if (it != null) curMax = Math.max(curMax, curSum - it.getElement());
                        s.add(curSum);
                    }
                    res = Math.max(res, curMax);
                }
            }
            return res;
        }


    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] input = {{1,0,1}, {0, -2, 3}};
        int ret = sol.maxSumSubmatrix(input, 2);
        System.out.println("result = " + ret);
    }

}
