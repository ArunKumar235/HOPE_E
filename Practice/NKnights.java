package Practice;
/*

print all possible combinations of k knights placed in an n*n board

input:
n = 3
k = 5

output:
K . K
. K .
K . K

. K .
K K K
. K .


 */
public class NKnights {
    public static void main(String[] args) {
        int n = 3;
        boolean[][] board = new boolean[n][n];
        int k = 3;
        knight(board, 0, 0, 5);
    }

    public static void knight(boolean[][] board, int row, int col, int k){
        if(k==0){
            display(board);
            return;
        }
        if(row== board.length -1 && col == board.length) return;
        if(col== board.length){
            knight(board, row+1, 0, k);
            return;
        }
        if(isSafe(board, row, col)){
            board[row][col] = true;
            knight(board, row, col+1, k-1);
            board[row][col] = false;
        }
        knight(board, row, col+1, k);
    }

    public static boolean isSafe(boolean[][] board, int row, int col){
        int[] rowDiff = {-2, -1,  1,  2,  2,   1,  -1,  -2};
        int[] colDiff = { 1,  2,  2,  1, -1,  -2,  -2,  -1};
        for(int i = 0; i<rowDiff.length; i++){
            if(isValid(board, row+rowDiff[i], col+colDiff[i])){
                if(board[row+rowDiff[i]][col+colDiff[i]]){
                    return false;
                }
            }
        }
        return true;

    }

    public static boolean isValid(boolean[][] board, int row, int col){
        return row >= 0 && row < board.length && col >= 0 && col < board.length;
    }

    public static void display(boolean[][] board){
        for(boolean[] row: board){
            for(int i = 0; i<board.length; i++){
                System.out.print(row[i] ? "K " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }
}