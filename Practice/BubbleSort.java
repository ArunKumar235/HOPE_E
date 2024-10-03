package Practice;

import java.util.Arrays;
/*

  Recursive bubble sort algorithm

(7,0) (7,1) (7,2) (7,3) (7,4) (7,5) (7,6)
(6,0) (6,1) (6,2) (6,3) (6,4) (6,5)
(5,0) (5,1) (5,2) (5,3) (5,4)
(4,0) (4,1) (4,2) (4,3)
(3,0) (3,1) (3,2)
(2,0) (2,1)
(1,0)

 */
public class BubbleSort {
    public static void main(String[] args) {
        int n = 8;
        int[] arr = {7,1,2,8,5,6,3,4};
        bubbleSort(arr,n-1,0);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr, int row, int col){
        if(row==0) return;
        if(row==col) {
//            System.out.println();
            bubbleSort(arr, row - 1, 0);
        }else{
//            System.out.print("("+row+","+col+") ");
            if(arr[col]>arr[col+1]){
                int temp = arr[col];
                arr[col] = arr[col+1];
                arr[col+1] = temp;
            }
            bubbleSort(arr,row,col+1);
        }
    }
}
