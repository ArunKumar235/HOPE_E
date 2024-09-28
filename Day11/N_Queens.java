package Day11;

/*

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.


Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N_Queens {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solveNQueens(n));
    }

    static List<List<String>> result = new ArrayList<>();
    static boolean rowF[];
    static boolean colF[];
    static boolean trblF[];
    static boolean tlbrF[];
    static boolean board[][];

    public static List<List<String>> solveNQueens(int n) {
        rowF = new boolean[n];
        colF = new boolean[n];
        tlbrF = new boolean[2*n -1];
        trblF = new boolean[2*n -1];
        board = new boolean[n][n];
        fill(0,n);
        return result;
    }

    public static void fill(int row, int n){
        if(row==n){
            // To do
            List<String> li = new ArrayList<>();
            for(int r = 0; r <n; r++){
                StringBuilder sb = new StringBuilder();
                for(int c = 0; c<n; c++){
                    sb.append((board[r][c]) ? "Q" : ".");
                }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }

        for(int col = 0; col<n; col++){
            if(!canPlace(row,col,n)) continue;
            rowF[row] = true;
            colF[col] = true;
            trblF[row+col] = true;
            tlbrF[n-1-(row-col)] = true;
            board[row][col] = true;
            fill(row+1, n);
            rowF[row] = false;
            colF[col] = false;
            trblF[row+col] = false;
            tlbrF[n-1-(row-col)] = false;
            board[row][col] = false;
        }
    }

    public static boolean canPlace(int row, int col, int n){
        return !(rowF[row] || colF[col] || trblF[row+col] || tlbrF[n-1-(row-col)] || board[row][col]);
    }
}