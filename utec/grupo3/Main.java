package utec.grupo3;
import java.util.Scanner; 

public class Main{
    public static void Main(String[] args){
        while(true){
            Sudoku s = new Sudoku();
            Scanner in =  new Scanner(System.in);

            System.out.println("Enter x: ");
            int x = in.nextInt();
            System.out.println("Enter y: ");
            int y = in.nextInt();
            System.out.println("Enter value: ");
            int val = in.nextInt();

            boolean valid = s.makeMove(x,y,val);
            if(!valid){
                System.out.println("Invalid move");
                continue;         
            }
            s.printBoard();
            if(s.isEnd()){
                System.out.println("Win");
                break;
            }
        } 
    }
}
