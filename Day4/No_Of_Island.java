package Day4;

import java.util.Scanner;

/*
https://leetcode.com/problems/number-of-islands/description/

4 5
1 1 1 1 0
1 1 0 1 0
1 1 0 0 0
0 0 0 0 0

 */

public class No_Of_Island {

    static int[] rowDiff = {-1, 0, 1,  0};
    static int[] colDiff = { 0, 1, 0, -1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        char[][] grid = new char[r][c];
        for(int i = 0 ;i<r; i++){
            for(int j = 0; j<c; j++){
                grid[i][j] = sc.next().charAt(0);
            }
        }
        numIslands(grid);


    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0 ;j<grid[0].length; j++){
                if(grid[i][j]=='1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] grid, int r, int c){
        if(grid[r][c]=='0') return;
        grid[r][c] = '0';
        for(int i = 0; i<4; i++){
            for(int j = 0; j<4; j++){
                int rpos = r + rowDiff[i];
                int cpos = c + colDiff[i];
                if(rpos>=0 && rpos<grid.length && cpos>=0 && cpos<grid[0].length){
                    if(grid[rpos][cpos]=='1') dfs(grid, rpos, cpos);
                }
            }
        }
    }
}
