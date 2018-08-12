package n_queens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    public class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<String> > res = new ArrayList<>();
            int[] pos = new int[n];
            for(int i = 0; i < n; ++i) pos[i] = -1;
            solveNQueensDFS(pos, 0, res);
            return res;
        }

        private void solveNQueensDFS(int[] pos, int row, List<List<String> > res) {
            int n = pos.length;
            if (row == n) {
                List<String> out = new ArrayList<>();
                for (int i = 0; i < n; ++i) {
                    char[] s = new char[n];
                    Arrays.fill(s, '.');
                    s[pos[i]] = 'Q';
                    out.add(new String(s));
                }
                res.add(new ArrayList<>(out));
            } else {
                for (int col = 0; col < n; ++col) {
                    if (isValid(pos, row ,col)) {
                        pos[row] = col;
                        solveNQueensDFS(pos, row + 1, res);
                        pos[row] = -1;  // back-tracking
                    }
                }
            }
        }

        private boolean isValid(int[] pos, int row, int col) {
            for (int i = 0; i < row; ++i) {
                if (col == pos[i] || Math.abs(row - i) == Math.abs(col - pos[i])) {
                    return false;
                }
            }
            return true;
        }

    }

    public static class UnitTest {

    }
}
