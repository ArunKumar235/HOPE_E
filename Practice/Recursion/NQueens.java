package Practice.Recursion;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        queens(board, 0, n, new boolean[n], new boolean[n], new boolean[2*n-1], new boolean [2*n-1]);
    }

    public static void queens(boolean[][] board, int row, int n, boolean[] safeR, boolean[] safeC, boolean[] tlbr, boolean[] trbl){
        if(row==n){
            displayBoard(board);
            return;
        }
        for(int col = 0; col<n; col++){
            if(issafe(board, row, col, safeR, safeC, tlbr, trbl)){
                board[row][col] = true;
                safeR[row] = true;
                safeC[col] = true;
                tlbr[row+col] = true;
                trbl[n-1-(row-col)] = true;
                queens(board ,row+1, n, safeR, safeC, tlbr, trbl);
                board[row][col] = false;
                safeR[row] = false;
                safeC[col] = false;
                tlbr[row+col] = false;
                trbl[n-1-(row-col)] = false;
            }
        }
    }

    public static boolean issafe(boolean[][] board, int row, int col, boolean[] safeR, boolean[] safeC, boolean[] tlbr, boolean[] trbl){
        return !(safeR[row] || safeC[col] || tlbr[row+col] || trbl[board.length-1-(row-col)] || board[row][col]);
    }

    public static void displayBoard(boolean[][] board){
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                System.out.print(board[i][j] ? "Q " : "X ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
