package utec.grupo3;
import java.lang.Math;

public class Sudoku{
    public void printBoard() {
        for (int i = 0; i < 9; i++) {
            System.out.print("\n");
            if (i % 3 == 0)
                System.out.print("\n");
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0)
                    System.out.print(" ");
                if(!this.board[i][j].mutable){
                  System.out.print("\u001B[31m" + this.board[i][j].val + "\u001B[0m" + " ");
                } else {
                  System.out.print(this.board[i][j].val + " ");
                }
            }
        }
    }
    private boolean checkRow(int number, int row, int col)
    {
        int r = r - 1;
        for (int c = 0; c < 9; ++c){
            if (this.board[r][c].val == number)
               return false;
        }
        return true;
    }

    private boolean checkCol(int number, int row, int col)
    {
        int c = col - 1;
        for (int r = 0; r < 9; ++r) {
            if (this.board[r][c].val == number)
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
                if (this.board[r][c].val == number)
                    return false;
            }
        }
        return true;
    }
  public boolean isEnd() {
    for (int col = 0; col < 9; ++col) {
      for (int row = 0; row < 9; ++row) {
        if (board[col][row] == 0)
        {
          return false;
        }
      }
    }
    return true;
  }
}
