package Day10;

import java.util.Arrays;
import java.util.Scanner;

public class Longest_Common_SubSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String b = sc.next(); // babgbag
        String a = sc.next(); // bag
        System.out.println(longestCommonSubSequence(a,b)); // 3
    }

    public static int longestCommonSubSequence(String a, String b) {
        int[][] mat = new int[a.length()+1][b.length()+1];
        for(int i = 1; i<=a.length(); i++){
            for(int j = 1; j<=b.length(); j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    mat[i][j] = mat[i-1][j-1] + 1;
                }else{
                    mat[i][j] = Math.max(mat[i][j-1], mat[i-1][j]);
                }
            }
        }
        for(int[] i: mat){
            System.out.println(Arrays.toString(i));
        }
        return mat[a.length()][b.length()];
    }
}
