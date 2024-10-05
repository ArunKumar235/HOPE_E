package Practice.Recursion;

import java.util.Arrays;

/*
    Recursive selection sort algorithm

    replace the maximum element at the last, recursively

 */

public class SelectionSort {
    public static void main(String[] args) {
        int n = 8;
        int[] arr = {7,1,2,8,5,6,3,4};
        selectionSort(arr,n,0, 0);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr, int row, int col, int max){
        if(row==0) return;
        if(row==col){
            int temp = arr[max];
            arr[max] = arr[row-1];
            arr[row-1] = temp;
            selectionSort(arr, row-1, 0, 0);
        }else if(arr[col] > arr[max]){
            selectionSort(arr,row ,col+1, col);
        }else{
            selectionSort(arr,row ,col+1, max);
        }
    }
}
