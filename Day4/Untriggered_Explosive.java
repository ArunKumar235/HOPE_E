package Day4;

import java.util.Scanner;

/*

5 5
E A A E W
A E B E A
X E A N N
C Z E E E
E Q B B E
1
2 2

 */

public class Untriggered_Explosive {

    static int[] rowDiff = {-1, -1, -1, 0, 1, 1,  1,  0};
    static int[] colDiff = {-1,  0,  1, 1, 1, 0, -1, -1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();
        char[][] arr = new char[r][c];
        for(int i = 0; i<r; i++){
            for(int j=0; j<c; j++){
                arr[i][j] = sc.next().charAt(0);
            }
        }
        int no_of_trigger = sc.nextInt();
        for(int i = 0; i<no_of_trigger; i++){
            int row = sc.nextInt();
            int col = sc.nextInt();
            dfs(arr, row-1, col-1);
        }
        System.out.println(countExplosive(arr));

    }

    public static void dfs(char[][] arr, int row, int col){
        if(arr[row][col] != 'E') return;
        arr[row][col] = 'T';
        for(int i = 0; i<8; i++){
            int rpos = row+rowDiff[i];
            int cpos = col+colDiff[i];
            if(rpos>=0 && rpos<arr.length && cpos>=0 && cpos<arr[0].length){
                if(arr[rpos][cpos] == 'E') dfs(arr, rpos, cpos);
            }
        }
    }

    public static int countExplosive(char[][] arr){
        int count = 0;
        for(int i = 0; i<arr.length; i++){
            for(int j = 0; j<arr[0].length; j++){
                if(arr[i][j]=='E'){
                    count++;
                }
            }
        }
        return count;
    }
}
