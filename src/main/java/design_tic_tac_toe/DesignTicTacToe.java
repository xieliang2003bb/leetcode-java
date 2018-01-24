package design_tic_tac_toe;

import static java.lang.StrictMath.abs;

/**
 * Created by lxie on 1/24/18.
 */
public class DesignTicTacToe {

    public class Solution {

        public class TicTacToe {
            private int N = 3;
            private int[] rows = new int[N];
            private int[] cols = new int[N];
            private int diag = 0, rev_diag = 0;

            public void TicTacToe(int n) {
                this.N = n;
            }

            public int move(int row, int col, int player) {
                int add = player == 1 ? 1 : -1;
                rows[row] += add; cols[col] += add;
                diag += (row == col ? add : 0);
                rev_diag += (row == N - col - 1 ? add : 0);
                return (abs(rows[row]) == N || abs(cols[col]) == N || abs(diag) == N
                        || abs(rev_diag) == N) ? player : 0;
            }

        }
    }


    public static class UnitTest {

    }

}
