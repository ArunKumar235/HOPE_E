package Miscellenous;

import java.util.Arrays;

public class HighestPower {
    public static void main(String[] args) {

        int n = 5;
        int[] arr = {2,4,2,1,6};
        int k = 4;
        int[] power = {4,1,1,3}; // op = 20

//        int n = 5;
//        int[] arr = {3,5,6,0,7};
//        int k = 4;
//        int[] power = {3,1,0,2}; // op = 25

//        int n = 6;
//        int[] arr = {7,3,12,8,5,4};
//        int k = 6;
//        int[] power = {4,3,2,0,0,1}; // op = 80



        int[] prefixSum = new int[n];

        int preSum = 0;
        for(int i = 0; i<n; i++){
            preSum += arr[i];
            prefixSum[i] = preSum;
        }

        Arrays.sort(power);

        int start = 0;
        int end = power.length-1;
        int sum = 0;

        while(start<=end){

            int startindex = power[start];
            int endindex = power[end];

            if(startindex>endindex){
                int temp = endindex;
                endindex = startindex;
                startindex = temp;
            }

            if(startindex==0) sum+= prefixSum[endindex];
            else sum += prefixSum[endindex] - prefixSum[startindex-1];

            start++;
            end--;
        }
        System.out.println(sum);
    }
}
