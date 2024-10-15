package Day13;

import java.util.Arrays;
/*

Derangement of a number refers to a permutation of the elements of a set, such that no element appears in its original position.

Example:
Let's say we have 3 elements {1, 2, 3}
The derangements of the elements are:
{2, 3, 1}
{3, 1, 2}

f(n) = (n-1)*(f(n-1)+f(n-2))

 */
public class DerangementOfNumberN {
    public static void main(String[] args) {
        int n = 6;
        int[] arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 0;
        arr[2] = 1;
        for(int i = 3; i<=n; i++){
            arr[i] = (i-1)*(arr[i-1]+arr[i-2]);
        }
        System.out.println(Arrays.toString(arr));
    }
}
