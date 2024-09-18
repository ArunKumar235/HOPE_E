package Day7;

/*

https://leetcode.com/problems/burst-balloons/description/

Burst one balloon at a time, every time you burst a balloon at i index, you earn arr[i-1]*arr[i]*arr[i+1] coins, once the balloon is burst, then it is gone, return the maximum number of coins that can e earned

4
3 1 5 8

op -> 167
 */

import java.util.Arrays;
import java.util.Scanner;

public class Bursting_Balloons {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N+2];
        for(int i =0; i<N; i++){
            arr[i+1] = sc.nextInt();
        }
        arr[0] = 1;
        arr[N+1] = 1;
        int[][] dp = new int[N+2][N+2];
        for(int i = 0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        System.out.println(solve(arr, dp, 1, N));
    }

    public static int solve(int[] arr, int[][] dp, int left, int right){
        if(left>right){
            return 0;
        }
        if(dp[left][right]!=-1){
            return dp[left][right];
        }
        int maxPoints = -1;
        for(int index = left; index <=right; index++){
            maxPoints = Math.max(maxPoints, solve(arr, dp, left, index-1)+solve(arr, dp, index+1, right)+arr[left-1]*arr[index]*arr[right+1]); // (left-1) and (right+1) is used instead of (index-1) and (index+1) because this will be the last balloon to be burst
        }
        dp[left][right] = maxPoints;
        return maxPoints;
    }
}
