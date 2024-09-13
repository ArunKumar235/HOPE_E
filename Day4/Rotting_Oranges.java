package Day4;

import java.util.*;

/*

https://leetcode.com/problems/rotting-oranges/description/

2 1 1
1 1 0
0 1 1

4 -> Output

You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 */

import java.util.*;
class orange{
    int row,col,mins;
    public orange(int r,int c,int m){
        this.row = r;
        this.col = c;
        this.mins= m;
    }
}
public class Rotting_Oranges{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] grid = new int[r][c];
        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        int unrottenCount = orangesRotting(grid);
        System.out.println(unrottenCount);
    }
    public static int orangesRotting(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int fresh = 0;
        Queue<orange> queue = new ArrayDeque<>();
        for(int i= 0;i <r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j] == 1){
                    fresh++;

                }
                else if(grid[i][j] == 2){
                    queue.add(new orange(i,j,0));
                    grid[i][j] = 0;
                }
            }
        }
        if(queue.isEmpty() && fresh == 0){
            return 0;
        }
        int maxMins = 0;
        int rowdiff[] = {-1,0,0,1};
        int coldiff[] = {0,-1,1,0};

        while(!queue.isEmpty()){
            orange curr = queue.poll();
            maxMins = Math.max(maxMins,curr.mins);
            for(int i=0;i<4;i++){
                int adjr = curr.row+rowdiff[i];
                int adjc = curr.col+coldiff[i];
                if(adjr >= 0 && adjr<r && adjc>=0 && adjc<c && grid[adjr][adjc] == 1){
                    queue.add(new orange(adjr,adjc,curr.mins+1));

                    fresh--;
                    grid[adjr][adjc] = 0;
                }
            }
        }
        if(fresh>0){
            return -1;
        }
        return maxMins;
    }
}