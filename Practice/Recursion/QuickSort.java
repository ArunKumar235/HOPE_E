package Practice.Recursion;

import java.util.Arrays;

/*
     Choose a pivot value, and shift all the smaller elements to the left of the pivot,
     and shift all the higher elements to the right of the pivot

     Recurrence relation
     T(N) = T(K) + T(N-K-1) + O(N)

     Stable : No
     BestCase :
        Time Complexity : O(N log(N))
        Space Complexity : O(log(N))
     WorstCase :
        Time Complexity : O(N^2)
        Space Complexity : O(N)
     When to use: In place sorting algorithm

 */

public class QuickSort {
    public static void main(String[] args) {
        int n = 8;
        int[] arr = {7,1,2,8,5,6,3,4};
        quickSort(arr,0,n-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int low, int high){
        if(low > high) return;
        int start = low;
        int end = high;
        int mid = start + (end-start)/2;
        int pivot = arr[mid];
        while(start <= end){
            while(arr[start]<pivot){
                start++;
            }
            while(arr[end]>pivot){
                end--;
            }
            if(start<=end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        quickSort(arr,low,end);
        quickSort(arr,start,high);

    }
}
