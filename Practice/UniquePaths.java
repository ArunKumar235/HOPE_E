package Practice;

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
//        int r = 3;
//        int c = 7;
//        System.out.println(uniquePathsRecursion(r,c));
//        System.out.println(uniquePathsDP(r,c));


//        int[][] grid = {
//                {0,0,0},
//                {0,1,0},
//                {0,0,0}
//        };
//        uniquePathsWithObstacles(grid, 0, 0, "");


        int[][] arr = new int[3][3];
        uniquePaths4DirectionPrintPath(arr,0,0, "", 1);
    }


    // Can move only in right and down direction
    public static int uniquePathsRecursion(int r, int c){
        if(r==1 || c== 1){
            return 1;
        }
        return uniquePathsRecursion(r-1,c)+ uniquePathsRecursion(r,c-1);
    }


    // Can move only in right and down direction
    public static int uniquePathsDP(int r, int c){
        int[][] arr = new int[r][c];
        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                if(i==0 || j==0) arr[i][j] = 1;
                else arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }
        return arr[r-1][c-1];
    }


    // Can move only in right and down direction, but the elements with value 1, show that the path is blocked
    public static void uniquePathsWithObstacles(int[][] arr, int r, int c, String path){
        if(r==arr.length-1 && c==arr[0].length-1){
            System.out.println(path);
            return;
        }
        if(arr[r][c] == 1) return;

        if (r < arr.length-1) uniquePathsWithObstacles(arr,r+1,c,path+"D");
        if (c < arr[0].length-1) uniquePathsWithObstacles(arr,r,c+1,path+"R");
    }



    // Can move in all four directions, backtracking is used to prevent revisiting visited elements
    // Print the path in the matrix
    public static void uniquePaths4DirectionPrintPath(int[][] arr, int r, int c, String path, int step){
        if(r==arr.length-1 && c==arr[0].length-1){
            arr[r][c] = step;
            for(int[] row: arr){
                System.out.println(Arrays.toString(row));
            }
            System.out.println(path);
            System.out.println();
            return;
        }
        if(arr[r][c] != 0) return;
        arr[r][c] = step;
        if(r+1 < arr.length){
            uniquePaths4DirectionPrintPath(arr,r+1,c,path+"D", step +1);
        }if(c+1 < arr[0].length){
            uniquePaths4DirectionPrintPath(arr,r,c+1,path+"R", step +1);
        }if(r > 0 ){
            uniquePaths4DirectionPrintPath(arr,r-1,c,path+"U", step +1);
        }if(c > 0){
            uniquePaths4DirectionPrintPath(arr,r,c-1,path+"L", step +1);
        }
        arr[r][c] = 0;
    }
}
