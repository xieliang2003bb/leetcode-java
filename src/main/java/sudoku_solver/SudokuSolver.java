package sudoku_solver;

import java.util.Arrays;

public class SudokuSolver {

    public class Solution {
        public boolean solveSudoku(char[][] board){
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    if(board[i][j] != '.')
                        continue;
                    for(char k = '1'; k <= '9'; k++){
                        board[i][j] = k;
                        if(checkValid(board,i,j)){
                            if(solveSudoku(board))
                                return true;
                        }
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
            return true;
        }

        private boolean checkValid(char[][] board, int x, int y){
            boolean[] flags = new boolean[9];
            for(int i = 0; i < 9; ++i)
                if(board[x][i] >= '1' && board[x][i] <= '9'){
                    if(!flags[board[x][i] - '1'])
                        flags[board[x][i] - '1'] = true;
                    else
                        return false;
                }
            Arrays.fill(flags, false);
            for(int i = 0; i < 9; ++i)
                if(board[i][y] >= '1' && board[i][y] <= '9'){
                    if(!flags[board[i][y] - '1'])
                        flags[board[i][y] - '1'] = true;
                    else
                        return false;
                }
            int xx = x/3*3;
            int yy = y/3*3;
            Arrays.fill(flags, false);
            for(int i = 0; i < 3; ++i)
                for(int j = 0; j < 3; ++j)
                    if(board[xx+i][yy+j] >= '1' && board[xx+i][yy+j]<= '9'){
                        if(!flags[board[xx+i][yy+j]-'1'])
                            flags[board[xx+i][yy+j]-'1'] = true;
                        else
                            return false;
                    }

            return true;
        }


    }

    public static class UnitTest {

    }
}
