package max_square;

/**
 * Created by lxie on 2/9/18.
 */
public class MaxSquare {

    public class Solution {
        public int maximalSquare(char[][] matrix) {
            int res = 0;
            for (int i = 0; i < matrix.length; ++i) {
                int[] v = new int[matrix[i].length];
                for (int j = i; j < matrix.length; ++j) {
                    for (int k = 0; k < matrix[j].length; ++k) {
                        if (matrix[j][k] == '1') ++v[k];
                    }
                    res = Integer.max(res, getSquareArea(v, j - i + 1));
                }
            }
            return res;
        }
        int getSquareArea(int[]v, int k) {
            if (v.length < k) return 0;
            int count = 0;
            for (int i = 0; i < v.length; ++i) {
                if (v[i] != k) count = 0;
                else ++count;
                if (count == k) return k * k;
            }
            return 0;
        }
    }

    public static class UnitTest {

    }

}
