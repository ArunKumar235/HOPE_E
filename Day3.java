import java.util.Arrays;
import java.util.HashMap;
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


//        Longest Common Subsequence
//        String str1 = sc.next(); // abacus
//        String str2 = sc.next(); // abcdef
//        longestSubSequenceLength(str1, str2); // 3 - abc


//        Sum of surrounding elements in matrix
//        int R = sc.nextInt(); // 3
//        int C = sc.nextInt(); // 3
//        int[][] matrix = new int[R][C]; // [1 1 1] [1 1 1] [1 1 1]
//        for(int i = 0; i<R; i++){
//            for(int j = 0; j<C; j++){
//                matrix[i][j] = sc.nextInt();
//            }
//        }
//        sumOfSurrounding(matrix); // [3 5 3] [5 8 5] [3 5 3]


//        Word Ladder
//        int n = sc.nextInt(); // 5
//        String[] arr = new String[n]; // [elephant gauge tap rig pox]
//        for(int i = 0; i<n; i++){
//            arr[i] = sc.next();
//        }
//        int start = sc.nextInt(); // 2
//        wordLadder(arr, start-1); // gauge elephant tap pox


//        Rotate array K times
//        int n = sc.nextInt(); // 5
//        int[] arr = new int[n]; // 1 2 3 4 5
//        for(int i = 0; i<n; i++){
//            arr[i] = sc.nextInt();
//        }
//        int k = sc.nextInt(); // 2
//        rotateArray(arr, k); // 4 5 1 2 3
    }

    public static void rotateArray(int[] arr, int k){
        k = k % arr.length;
        reverseArray(arr, 0, arr.length-1);
        reverseArray(arr, 0, k-1);
        reverseArray(arr, k, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void reverseArray(int[] arr, int left, int right){
        while(left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void wordLadder(String[] arr, int start){
        HashMap<Character, Integer> firstCharMap = new HashMap<>();
        for(int idx = 0; idx<arr.length; idx++){
            firstCharMap.put(arr[idx].charAt(0), idx);
        }
        char ch = arr[start].charAt(0);
        while(firstCharMap.containsKey(ch)){
            int idx = firstCharMap.get(ch);
            System.out.print(arr[idx]+" ");
            ch = arr[idx].charAt(arr[idx].length()-1);
        }
    }

    public static void sumOfSurrounding(int[][] matrix){
        int R = matrix.length;
        int C = matrix[0].length;
        int[] rowDiff = {-1,-1,-1, 0, 1, 1, 1, 0};
        int[] colDiff = {-1, 0, 1, 1, 1, 0,-1,-1};
        int[][] result = new int[R][C];
        for(int row = 0; row<R; row++){
            for(int col = 0; col<C; col++){
                int sum = 0;
                for(int i = 0; i<8; i++){
                    int adjR = row+rowDiff[i];
                    int adjC = col+colDiff[i];
                    if(adjR >= 0 && adjR < R && adjC >= 0 && adjC < C ){
                        sum+=matrix[adjR][adjC];
                    }
                }
                result[row][col] = sum;
            }
        }
        for(int[] i: result){
            System.out.println(Arrays.toString(i));
        }
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
        System.out.println(dp[row][col]);
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
