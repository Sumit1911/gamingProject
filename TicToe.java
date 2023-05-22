import java.util.*;
public class TicToe {
    public static void main(String args[]) {
        TicTacToe t = new TicTacToe();
        HumanPlayer p1 = new HumanPlayer("Sumit", 'X');
        HumanPlayer p2 = new HumanPlayer("Chotu", 'O');

        HumanPlayer cp;
        cp = p1;
        while(true) {
            System.out.println(cp.name + " turn : ");
            cp.makeMove();
            TicTacToe.dispBoard();

            if(TicTacToe.checkRowWin() || TicTacToe.checkColWin() || TicTacToe.checkDiaWin()) {
                System.out.println(cp.name + " has won");
                break;
            } else {
                if(cp == p1) {
                    cp = p2;
                }
                else {
                    cp = p1;
                }
            }
        }
        
        
    }
}
class TicTacToe {
    static char ch[][];
    public TicTacToe() {
        ch = new char[3][3];
        initBoard();
    }
    void initBoard() {
        for(int i = 0; i<3; i++) {
            for(int j = 0; j<3; j++) {
                ch[i][j] = ' ';
            }
        }
    }
    static void dispBoard() {
        System.out.print("-------------");
        System.out.println();
        for(int i = 0; i<3; i++) {
            System.out.print("| ");          
            for(int j = 0; j<3; j++) {
                System.out.print(ch[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");           
        }
    }

    static void placeMark(int row, int col, char mark) {
       if(row>=0 && row<=2 && col>=0 && col<=2) {
        ch[row][col] = mark;
       } else {
        System.out.println("Invalid Position");
       }
    }
    
    static boolean checkRowWin() {
        for(int i = 0; i<3; i++) {
            if(ch[i][0] != ' ' && ch[i][0] == ch[i][1] && ch[i][1] == ch[i][2]) {
                return true;
            }
        }
        return false;
    }
    static boolean checkColWin() {
        for(int i = 0; i<3; i++) {
            if(ch[0][i] != ' ' && ch[0][i] == ch[1][i] && ch[1][i] == ch[2][i]) {
              return true;
            }
        }
        return false;
    }
    static boolean checkDiaWin() {
        for(int i = 0; i<3; i++) {
            if(ch[0][0] != ' ' && ch[0][0] == ch[1][1] && ch[1][1] == ch[2][2] && ch[2][0] == ch[1][1] && ch[1][1] == ch[0][2]) {
                return true;
            }
        }
        return false;
    }
}

class HumanPlayer {
    String name;
    char mark;
    HumanPlayer(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }
    void makeMove() {
        Scanner sc = new Scanner(System.in);
        int row, col;
        do {
        System.out.println("Enter row and col : ");
        row = sc.nextInt();
        col = sc.nextInt();
        } while(!isValidMove(row, col));
        TicTacToe.placeMark(row, col, mark);

    }
    boolean isValidMove(int row, int col) {
        if(row>=0 && row<=2 && col>=0 && col<=2) {
            if(TicTacToe.ch[row][col] == ' ') {
                return true;
            }           
        }
        return false;
    }

}
