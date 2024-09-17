package Day5;

import java.util.Scanner;

public class Median_Of_Two_Sorted_Array {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 2
        int[] nums1 = new int[n]; // 1 2
        for(int i = 0; i<n; i++){
            nums1[i] = sc.nextInt();
        }
        int m = sc.nextInt(); // 2
        int[] nums2 = new int[n]; // 3 4
        for(int i = 0; i<m; i++){
            nums2[i] = sc.nextInt();
        }
        System.out.println(findMedianSortedArrays(nums1, nums2)); // 2.50000
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[(nums1.length + nums2.length)/2 + 1];
        int n1 = nums1.length;
        int n2 = nums2.length;
        int a = arr.length;
        int i = 0;
        int j = 0;
        int k = 0;
        while(i<n1 && j<n2 && k<a){
            if(nums1[i] < nums2[j]){
                arr[k++] = nums1[i++];
            }else{
                arr[k++] = nums2[j++];
            }
        }
        while(i<n1 && k<a){
            arr[k++] = nums1[i++];
        }
        while(j<n2 && k<a){
            arr[k++] = nums2[j++];
        }
        if((n1+n2) % 2 == 0){
            return (arr[a-1]+arr[a-2])/2.0;
        }
        return arr[arr.length-1];
    }
}
