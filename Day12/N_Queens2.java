package Day12;

import java.util.Scanner;


/*

https://leetcode.com/problems/n-queens-ii/description/


The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.

Input: n = 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle.

Input: n = 1
Output: 1

 */


public class N_Queens2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(totalNQueens(n));
    }

    static boolean[] rowF;
    static boolean[] colF;
    static boolean[] tlbrF;
    static boolean[] trblF;
    static boolean[][] board;
    static int count = 0;

    public static int totalNQueens(int n) {
        rowF = new boolean[n];
        colF = new boolean[n];
        tlbrF = new boolean[2*n -1];
        trblF = new boolean[2*n -1];
        board = new boolean[n][n];
        fill(0,n);
        return count;
    }

    public static void fill(int row, int n){
        if(row==n){
            count++;
            return;
        }
        for(int col = 0; col<n; col++){
            if(!canPlace(row,col, n)) continue;
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
        return !(rowF[row]||colF[col]||trblF[row+col]||tlbrF[n-1-(row-col)]||board[row][col]);
    }
}