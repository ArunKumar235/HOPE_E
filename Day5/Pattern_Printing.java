package Day5;

import java.util.Arrays;
import java.util.Scanner;

/*

5

1
2 9
3 7 10
4 7 11 14
5 6 12 13 15


7

1
2 13
3 12 14
4 11 15 22
5 10 16 21 23
6 9 17 20 24 27
7 8 18 19 25 26 28

 */
public class Pattern_Printing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] mat = new int[n][n];
        int x = 1;
        for(int i = 0; i<n; i++){
            if (i%2==0){
                for(int j = i; j<n; j++){
                    mat[j][i] = x++;
                }
            }else{
                for(int j = n-1; j>=i; j--){
                    mat[j][i] = x++;
                }
            }

        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<=i; j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}
