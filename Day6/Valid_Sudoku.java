package Day6;

/*


5 3 . . 7 . . . .
6 . . 1 9 5 . . .
. 9 8 . . . . 6 .
8 . . . 6 . . . 3
4 . . 8 . 3 . . 1
7 . . . 2 . . . 6
. 6 . . . . 2 8 .
. . . 4 1 9 . . 5
. . . . 8 . . 7 9


 */


import java.util.Scanner;

public class Valid_Sudoku {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] mat = new char[9][9];
        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                mat[i][j] = sc.next().charAt(0);
            }
        }
        System.out.println(isValidSudoku(mat));
    }

    public static boolean isValidSudoku(char[][] board) {
        int[] rFlag = new int[9];
        int[] cFlag = new int[9];
        int[] smFlag = new int[9];
        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                if(board[i][j]=='.') continue;
                int val = board[i][j]-'1';
                int smidx = (i/3)*3 + (j/3);
                if((rFlag[i]&(1<<val))!=0) return false;
                if((cFlag[j]&(1<<val))!=0) return false;
                if((smFlag[smidx]&(1<<val))!=0) return false;
                rFlag[i] |= 1<<val;
                cFlag[j] |= 1<<val;
                smFlag[smidx] |= 1<<val;
            }
        }
        return true;
    }
}
