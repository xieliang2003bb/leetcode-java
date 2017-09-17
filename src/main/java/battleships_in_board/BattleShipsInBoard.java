package battleships_in_board;

/**
 * Created by lxie on 9/16/17.
 */
public class BattleShipsInBoard {

    class Solution {
        public int countBattleships(char[][] board) {
            if (board.length ==  0 || board[0].length == 0) return 0;
            int m = board.length, n = board[0].length, res = 0;
            boolean[][] visited = new boolean[m][n];   // default is all false

            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (board[i][j] == 'X' && !visited[i][j]) {
                        int[] lineOrCol = {0, 0};
                        dfs(board, visited, lineOrCol, i, j);
                        if (lineOrCol[0] == i || lineOrCol[1] == j) ++res;
                    }
                }
            }
            return res;
        }
        void dfs(char[][] board, boolean[][] visited, int[] linecol, int i, int j) {
            int m = board.length, n = board[0].length;
            if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || board[i][j] == '.') return;
            linecol[0] |= i; linecol[1] |= j;
            visited[i][j] = true;
            dfs(board, visited, linecol, i - 1, j);
            dfs(board, visited, linecol, i + 1, j);
            dfs(board, visited, linecol, i, j - 1);
            dfs(board, visited, linecol, i, j + 1);
        }

    }


    public static void main(String[] args) {
        System.out.println("this is for test");
    }



}
