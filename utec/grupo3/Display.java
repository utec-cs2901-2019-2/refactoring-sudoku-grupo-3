
public static void printBoard(Sudoku){
    for (int i = 0; i < 9; i++) {
            System.out.print("\n");
            if(i%3==0)
                System.out.print("\n");
        for (int j = 0; j < 9; j++) {
            if (j % 3 == 0)
                System.out.print(" ");
            if (sudoku[i][j].val == 0)
                System.out.print("  ");
            if (sudoku[i][j].val == 1)
                System.out.print("1 ");
            if (sudoku[i][j].val == 2)
                System.out.print("2 ");
            if (sudoku[i][j].val == 3)
                System.out.print("3 ");
            if (sudoku[i][j].val == 4)
                System.out.print("4 ");
            if (sudoku[i][j].val == 5)
                System.out.print("5 ");
            if (sudoku[i][j].val == 6)
                System.out.print("6 ");
            if (sudoku[i][j].val == 7)
                System.out.print("7 ");
            if (sudoku[i][j].val == 8)
                System.out.print("8 ");
            if (sudoku[i][j].val == 9)
                System.out.print("9 ");
        }
    }
    }