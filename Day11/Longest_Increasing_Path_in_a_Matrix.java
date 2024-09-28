package Day11;

import java.util.Scanner;

/*

https://leetcode.com/problems/longest-increasing-path-in-a-matrix/

 Given an m x n integers matrix, return the length of the longest increasing path in matrix.

 From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).

 Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]

3 3
9 9 4
6 6 8
2 1 1

 Output: 4
 Explanation: The longest increasing path is [1, 2, 6, 9].

 9   9   4
 |
 6   6   8
 |
 2 - 1   1

[1,  1,  2]
[2,  2,  1]
[3,  4,  2]

 */
public class Longest_Increasing_Path_in_a_Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] mat = new int[r][c];
        for(int i =0 ; i<r; i++){
            for(int j = 0; j<c; j++){
                mat[i][j] = sc.nextInt();
            }
        }
        System.out.println(longestIncreasingPath(mat));

    }

    public static int longestIncreasingPath(int[][] mat) {
        int R = mat.length;
        int C = mat[0].length;
        int[][] dp = new int[R][C];
        int max = -1;
        for(int i = 0;i <R; i++){
            for(int j = 0; j<C; j++){
                dp[i][j] = dfs(mat,dp,i,j,R,C,-1);
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
    public static int dfs(int[][] mat, int[][] dp, int row, int col, int R, int C, int prev){
        if(row>=R || row<0 || col>=C || col<0){
            return 0;
        }
        if(mat[row][col]<=prev){
            return 0;
        }
        if(dp[row][col]!=0){
            return dp[row][col];
        }
        int top = dfs(mat, dp, row-1, col, R, C, mat[row][col]);

        int bottom = dfs(mat, dp, row+1, col, R, C, mat[row][col]);

        int left = dfs(mat, dp, row, col-1, R, C, mat[row][col]);

        int right = dfs(mat, dp, row, col+1, R, C, mat[row][col]);

        dp[row][col] = Math.max(Math.max(top,bottom), Math.max(left, right)) + 1;

        return dp[row][col];
    }
}
