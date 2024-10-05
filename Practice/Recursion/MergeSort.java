package Practice.Recursion;

import java.util.Arrays;
/*
     Recursively split the array into two parts, until they return a single element,
     now merge it to form a sorted array

     Recurrence relation
     T(N) = 2T(N/2) + O(N)

     Stable : Yes
     BestCase/ WorstCase Time Complexity : O(N^2)
     Space Complexity : O(N)
     When to use: In a linked list, because not continuous memory allocation

 */
public class MergeSort {
    public static void main(String[] args) {
        int n = 8;
        int[] arr = {7,1,2,8,5,6,3,4};

//        arr = mergeSort(arr);

        mergeSortInPlace(arr, 0, n);

        System.out.println(Arrays.toString(arr));
    }

//    Merge sort in place
    public static void mergeSortInPlace(int[] arr, int start, int end){
        if(end-start==1) return;
        int mid = start + (end-start)/2;
        mergeSortInPlace(arr,start,mid);
        mergeSortInPlace(arr,mid,end);
        merge(arr,start,mid,end);
    }

    public static void merge(int[] arr, int start, int mid, int end){
        int[] mix = new int[end-start];
        int i = start;
        int j = mid;
        int k = 0;
        while(i<mid && j<end){
            if(arr[i]<arr[j]){
                mix[k++] = arr[i++];
            }else{
                mix[k++] = arr[j++];
            }
        }
        while(i<mid){
            mix[k++] = arr[i++];
        }
        while(j<end){
            mix[k++] = arr[j++];
        }

        for(i = 0; i<k; i++){
            arr[start+i] = mix[i];
        }
    }

//    Merge Sort by creating a new array of left and right
    public static int[] mergeSort(int[] arr){
        if(arr.length==1) return arr;
        int start = 0;
        int end = arr.length;
        int mid = arr.length/2;
        int[] first = mergeSort(Arrays.copyOfRange(arr,start,mid));
        int[] second = mergeSort(Arrays.copyOfRange(arr,mid,end));
        return merge(first, second);
    }

    public static int[] merge(int[] first, int[] second){
        int[] mix = new int[first.length + second.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i<first.length && j<second.length){
            if(first[i]<second[j]){
                mix[k++] = first[i++];
            }else{
                mix[k++] = second[j++];
            }
        }
        while(i<first.length){
            mix[k++] = first[i++];
        }
        while(j<second.length){
            mix[k++] = second[j++];
        }
        return mix;
    }

}
