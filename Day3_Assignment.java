import java.util.*;

/*

https://www.hackerrank.com/challenges/matrix-rotation-algo/problem

4
4
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
2


5
4
1 2 3 4
7 8 9 10
13 14 15 16
19 20 21 22
25 26 27 28
7

*/

public class Day3_Assignment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        List<List<Integer>> matrix = new ArrayList<>();
        for(int i = 0; i<r; i++){
            List<Integer> li = new ArrayList<>();
            for(int j = 0; j<c; j++){
                int num = sc.nextInt();
                li.add(num);
            }
            matrix.add(li);
        }
        int k = sc.nextInt();

        matrixRotation(matrix, k);
    }

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int left = 0;
        int top = 0;
        int bottom = matrix.size()-1;
        int right = matrix.get(0).size()-1;
        // Get the elements of matrix in layer form
        while(top<=bottom && left<=right){

            int orginalLeft = left;
            int orginalRight = right;
            int orginalTop = top;
            int orginalBottom = bottom;

            // List for every Layer
            ArrayList<Integer> layer = new ArrayList<>();
            // left to right
            for(int i = left; i<=right; i++){
                layer.add(matrix.get(top).get(i));
            }
            top++;
            // top to bottom
            for(int i = top; i<=bottom; i++){
                layer.add(matrix.get(i).get(right));
            }
            right--;
            if(top<=bottom){
                // right to left
                for(int i = right; i>=left; i--){
                    layer.add(matrix.get(bottom).get(i));
                }
                bottom--;
            }if(left<=right){
                //bottom to top
                for(int i = bottom; i>=top; i--){
                    layer.add(matrix.get(i).get(left));
                }
                left++;
            }


            //System.out.println(layer);
            rotateArray(layer, r);
            //System.out.println(layer);


            int x = 0;
            // left to right
            for(int i = orginalLeft; i<=orginalRight; i++){
                //layer.add(matrix.get(top).get(i));
                matrix.get(orginalTop).set(i, layer.get(x++));
            }
            orginalTop++;
            // top to bottom
            for(int i = orginalTop; i<=orginalBottom; i++){
                //layer.add(matrix.get(i).get(right));
                matrix.get(i).set(orginalRight, layer.get(x++));
            }
            orginalRight--;
            if(orginalTop<=orginalBottom){
                // right to left
                for(int i = orginalRight; i>=orginalLeft; i--){
                    //layer.add(matrix.get(bottom).get(i));
                    matrix.get(orginalBottom).set(i, layer.get(x++));
                }
                orginalBottom--;
            }if(orginalLeft<=orginalRight){
                //bottom to top
                for(int i = orginalBottom; i>=orginalTop; i--){
                    //layer.add(matrix.get(i).get(left));
                    matrix.get(i).set(orginalLeft, layer.get(x++));
                }
                orginalLeft++;
            }
        }

        for (List<Integer> integers : matrix) {
            for (int j = 0; j < matrix.get(0).size(); j++) {
                System.out.print(integers.get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void rotateArray(List<Integer> arr, int k){
        k = k % arr.size();
        reverseArray(arr, 0, arr.size()-1);
        reverseArray(arr, 0, arr.size()-k-1);
        reverseArray(arr, arr.size()-k, arr.size()-1);
    }

    public static void reverseArray(List<Integer> arr, int left, int right){
        while(left<right){
            int temp = arr.get(left);
            arr.set(left, arr.get(right));
            arr.set(right, temp);
            left++;
            right--;
        }
    }

}