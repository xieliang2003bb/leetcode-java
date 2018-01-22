package sparse_matrix_multiplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxie on 1/21/18.
 */
public class SparseMatrixMultiplication {

    public class Solution {

        public int[][] multiply(int[][] A, int[][] B) {
            // Write your code here
            int n = A.length;
            int m = B[0].length;
            int t = A[0].length;
            int[][] C = new int[n][m];

            List<List<Integer>> col = new ArrayList<>();
            for (int i = 0; i < t; i++) {
                col.add(new ArrayList<>());
                for (int j = 0; j < m; j++) {
                    if (B[i][j] != 0) {
                        col.get(i).add(j);
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < t; k++) {
                    if (A[i][k] == 0) {
                        continue;
                    }
                    for (int p = 0; p < col.get(k).size(); p++) {
                        int j = col.get(k).get(p);
                        C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
            return C;
        }

    }

    public static class UnitTest {
        
    }

}
