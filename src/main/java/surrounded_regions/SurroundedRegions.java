package surrounded_regions;

public class SurroundedRegions {

    public class Solution {
        
        public void solve(char[][] board) {
            for (int i = 0; i < board.length; ++i) {
                for (int j = 0; j < board[i].length; ++j) {
                    if ((i == 0 || i == board.length - 1 || j == 0 ||
                            j == board[i].length - 1) && board[i][j] == 'O')
                        solveDFS(board, i, j);
                }
            }
            for (int i = 0; i < board.length; ++i) {
                for (int j = 0; j < board[i].length; ++j) {
                    if (board[i][j] == 'O') board[i][j] = 'X';
                    if (board[i][j] == '$') board[i][j] = 'O';
                }
            }
        }

        private void solveDFS(char[][]board, int i, int j) {
            if (board[i][j] == 'O') {
                board[i][j] = '$';
                if (i > 0 && board[i - 1][j] == 'O')
                    solveDFS(board, i - 1, j);
                if (j < board[i].length - 1 && board[i][j + 1] == 'O')
                    solveDFS(board, i, j + 1);
                if (i < board.length - 1 && board[i + 1][j] == 'O')
                    solveDFS(board, i + 1, j);
                if (j > 1 && board[i][j - 1] == 'O')
                    solveDFS(board, i, j - 1);
            }
        }
    }

    public static class UnitTest {

    }
}
