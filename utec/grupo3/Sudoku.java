package utec.grupo3;
import java.util.*

public class Sudoku{

	int [9][9] solved_board;
	Cell [9][9] board;

	private generateBoard(){
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
		Set<int> inBox;
        int num;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                do {
                    num = randomGenerator(9);
                } while (inBox.contains(num));

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
                solve_board[i][j] = num;
				
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
				board[y][x] = new Cell(false);
				board[y][x].val = solved_board[i][j];
			}
		}

		for(int i = 0; i < 20; i++){
			int x = randomGenerator(9);
			int y = randomGenerator(9);

			board[y][x].val = 0;
			board[y][x].mutable = true;
		}

	}

	int randomGenerator(int num) {
        return (int) Math.floor((Math.random()*num+1));
    }

}
