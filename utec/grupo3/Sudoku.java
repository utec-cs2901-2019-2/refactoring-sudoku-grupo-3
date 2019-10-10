package utec.grupo3;
import java.util.*;
import java.lang.Math;

public class Sudoku{

	int[][] solved_board = new int[9][9];
	Cell[][] board = new Cell[9][9];

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

	private void generateBoard(){
        fillDiagonal(); 
        fillRemaining(0, 3); 
        removeDigits(); 
	}

	void fillDiagonal() {
        for (int i = 0; i < 9; i = i + 3) {
            fillBox(i, i);
		}
    }

	void fillBox(int row, int col) {
		Set<Integer> inBox = new HashSet<Integer>();
        int num;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                do {
                    num = randomGenerator(9);
                } while (inBox.contains(num));

				inBox.add(num);
                solved_board[row + i][col + j] = num;
            }
        }
	}

	boolean fillRemaining(int i, int j) {
        if (j >= 9 && i >= 9) {
			return true;
        }

        if (j >= 9) {
			j = 0;
			i++;
		}

        if (i < 3) {
            if (j < 3) {
                j = 3;
			}
        }

        else if (i < 3) {
            if (j == (int)(i / 3)*3) {
                j =  j + 3;
			}
        }

        else {
            if (j ==  6) {
                i = i + 1;
                j = 0;
                if (i >= 9) {
                    return true;
				}
            }
        }

        for (int num = 1; num <= 9; num++) {
            if (CheckIfSafe(i, j, num)) {
                solved_board[i][j] = num;
				
                if (fillRemaining(i, j+1)) {
                    return true;
				}

                solved_board[i][j] = 0;
            }
        }

        return false;
    }

	boolean CheckIfSafe(int i,int j,int num) {
        return (checkRow(num, i, j) && checkCol(num, i, j) && checkQuad(num, i, j));
    }

	void removeDigits(){

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				board[i][j] = new Cell(false);
				board[i][j].val = solved_board[i][j];
			}
		}

		for(int i = 0; i < 20; i++){
			int x = randomGenerator(9);
			int y = randomGenerator(9);

			board[y][x] = new Cell(true);
			board[y][x].val = 0;
		}

	}

	int randomGenerator(int num) {
        return (int) Math.floor((Math.random()*num+1));
    }

    private boolean checkRow(int number, int row, int col)
    {
        int r = row - 1;
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

        for (int r = rs; r < rs + 3; ++r) {
            for (int c = cs; c < cs + 3; ++cs) {
                if (this.board[r][c].val == number)
                    return false;
            }
        }
        return true;
    }
    
    public boolean makeMove(int number, int row, int col)
    {
        if (this.checkRow(number, row, col) && this.checkCol(number, row, col) && this.checkQuad(number, row, col)) {
            if (this.board[row][col].mutable == true)
            {
                this.board[row][col].val = number;
            }
        }
        return false;
    }

    public boolean isEnd() {
        for (int col = 0; col < 9; ++col) {
            for (int row = 0; row < 9; ++row) {
                if (board[col][row].val == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
