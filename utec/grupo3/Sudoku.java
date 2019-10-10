package utec.grupo3;

public class Sudoku{
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
