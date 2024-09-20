package Day9;

/*

Given an r*c matrix, print the max sum that can be obtained by adding only 1 value at a row
also following a condition,
if you pick a value from a 1st row, then you cannot pick a value from the same column in 2nd row, however you can pick a value from same column in 3rd row

4  4
20 50 100 120
200 100 60 400
60 50 70 900
500 100 90 200

op -> 1720
1st row -> 120
2nd row -> 200  // you can't choose 400 because you have already chosen a value from same column in top row
3rd row -> 900
4th row -> 500

we solve this using dp approach
create a new r*c matrix and copy the values from 1st row, and create a 2d matrix holding first max and second max values of every row in dp matrix
iterate from second row, if you are in i,j element, check if dp[i-1][j] != F.max[i-1] if this condition is true then dp[i][j] = F.max[i-1]+arr[i][j]
if dp[i-1][j] == F.max[i-1], then dp[i][j] = S.max[i-1]+arr[i][j]


|     dp matrix       |     | F.max   S.max |
  20    50   100   120         120      100
 320   220   180   500         500      320
 560   550   570  1220        1220      570
1720  1320  1310   770        1720     1320

op -> 1720



 */

import java.util.Scanner;

public class Max_Coins_Bottom_Row_Cannot_Pick {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] arr = new int[r][c];
        for(int i =0 ; i<r; i++){
            for(int j = 0; j<c; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(find_Max_Coins_Without_Picking_Same_Column_Bottom_Row(arr));


    }

    public static int find_Max_Coins_Without_Picking_Same_Column_Bottom_Row(int[][] arr) {
        int r = arr.length;
        int c = arr[0].length;
        int[][] dp = new int[r][c];
        int[][] maxValues = new int[r][2];
        int Fmax = -1;
        int Smax = -1;
        for(int j = 0; j <c; j++){
            dp[0][j] = arr[0][j];
            if(Fmax<arr[0][j]){
                Smax = Fmax;
                Fmax = arr[0][j];
            }else if(Smax < arr[0][j]){
                Smax = arr[0][j];
            }
        }
        maxValues[0][0] = Fmax;
        maxValues[0][1] = Smax;
        for(int i = 1; i<r; i++){
            Fmax = -1;
            Smax = -1;
            for(int j = 0; j<c; j++){
                // Updating the values of dp matrix
                if(dp[i-1][j]!=maxValues[i-1][0]){
                    dp[i][j] = arr[i][j] + maxValues[i-1][0];
                }else{
                    dp[i][j] = arr[i][j] + maxValues[i-1][1];
                }
                // Updating the values of maxValue matrix i.e. F.max[i] value and S.max[i] value
                if(Fmax<dp[i][j]){
                    Smax = Fmax;
                    Fmax = dp[i][j];
                }else if(Smax < dp[i][j]){
                    Smax = dp[i][j];
                }
            }
            maxValues[i][0] = Fmax;
            maxValues[i][1] = Smax;
        }
        return maxValues[r-1][0];
    }
}