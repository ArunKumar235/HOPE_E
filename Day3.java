import java.util.Arrays;
import java.util.Scanner;

public class Day3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

//        Longest increasing subsequence
//        int n = sc.nextInt(); // 10
//        int[] arr = new int[n]; // -7 1 3 2 4 10 9 8 11 15
//        for(int i = 0; i<n; i++){
//            arr[i] = sc.nextInt();
//        }
//        longestIncreasingSubSequence(arr); // 7


//        Maximum sum of subarray
//        int n = sc.nextInt(); // 10
//        int[] arr = new int[n]; // 50 -100 20 30 -100 50 60 100 -200 -10
//        for(int i = 0; i<n; i++){
//            arr[i] = sc.nextInt();
//        }
//        subarrayMaxSum(arr); // 210 // Kadane's Algorithm


//        Lonest Commonn Subsequence
//        String str1 = sc.next(); // abacus
//        String str2 = sc.next(); // abcdef
//        longestSubSequenceLength(str1, str2);

    }

    public static void longestSubSequenceLength(String str1, String str2){
        int row = str1.length();
        int col = str2.length();

        int[][] dp = new int[row+1][col+1];

        for(int r = 1; r<=row; r++){
            for(int c = 1; c<=col; c++){
                if(str1.charAt(r-1)==str2.charAt(c-1)){
                    dp[r][c] = dp[r-1][c-1] + 1;
                }else{
                    dp[r][c] = Math.max(dp[r-1][c], dp[r][c-1]);
                }
            }
        }
    }

    public static void subarrayMaxSum(int[] arr){
        int maxSum = arr[0];
        int currSum = arr[0];
        for(int idx = 0; idx<arr.length; idx++){
            currSum+=arr[idx];
            if(currSum > maxSum){
                maxSum = currSum;
            }
            if(currSum<0){
                currSum = 0;
            }
        }
        System.out.println(maxSum);
    }

    public static void longestIncreasingSubSequence(int[] arr){
        int[] count = new int[arr.length];
        Arrays.fill(count, 1);
        int result = 1;
        for(int curr = 1; curr<arr.length; curr++){
            for(int prev = curr; prev>=0; prev--){
                if(arr[curr]>=arr[prev]){
                    count[curr] = Math.max(count[prev]+1, count[curr]);
                    result = Math.max(result, count[curr]);
                }
            }
        }
        System.out.println(result);
    }
}
