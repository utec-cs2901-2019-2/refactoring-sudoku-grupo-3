package utec.grupo3;

public class Sudoku {

    public static void printBoard() {
        for (int i = 0; i < 9; i++) {
            System.out.print("\n");
            if (i % 3 == 0)
                System.out.print("\n");
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0)
                    System.out.print(" ");
                if(!(board[i][j].mutable)){
                  System.out.print("\u001B[31m" + board[i][j].val + "\u001B[0m" + " ");
                } else {
                  System.out.print(board[i][j].val + " ");
                }
            }
        }
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
