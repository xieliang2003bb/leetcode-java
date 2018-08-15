package valid_sudoku;

public class ValidSudoku {

    public class Solution {
        public boolean isValidSudoku(char[][] board) {
            int m = board.length, n = board[0].length;
            boolean[][] rows = new boolean[m][n];
            boolean[][] columns = new boolean[m][n];
            boolean[][] cells = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == '.') {
                        continue;
                    }
                    int c = board[i][j] - '1';
                    if (rows[i][c] || columns[c][j]
                            || cells[i / 3 * 3 + j / 3][c]) {
                        return false;
                    }
                    rows[i][c] = columns[c][j] = cells[i / 3 * 3 + j / 3][c] = true;
                }
            }
            return true;
        }
    }

    public static class UnitTest {

    }
}
