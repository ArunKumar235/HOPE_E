import java.util.Arrays;
import java.util.Scanner;

public class Day3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Longest increasing subsequence
        int n = sc.nextInt(); // 10
        int[] arr = new int[n]; // -7 1 3 2 4 10 9 8 11 15
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        longestIncreasingSubSequence(arr); // 7

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
