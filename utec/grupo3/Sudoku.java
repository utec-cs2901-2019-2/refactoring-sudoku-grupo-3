package utec.grupo3;

import java.lang.Math;

public class Sudoku{

    private boolean checkRow(int number, int row, int col)
    {
        int r = r - 1;
        for (int c = 0; c < 9; ++c){
            if (this.board[r][c] == number)
               return false;
        }
        return true;
    }

    private boolean checkCol(int number, int row, int col)
    {
        int c = col - 1;
        for (int r = 0; r < 9; ++r) {
            if (this.board[r][c] == number)
               return false;
        }
        return true;
    }

    private boolean checkQuad(int number, int row, int col)
    {
        int rs = 3 * (int) Math.floor((row - 1) / 3);
        int cs = 3 * (int) Math.floor((col - 1) / 3);
        
        for (int r = rs; r < rs + 3; ++r)
        {
            for (int c = cs; c < cs + 3; ++cs)
            {
                if (this.board[r][c] == number)
                    return false;
            }
        }
        return true;
    }
}
