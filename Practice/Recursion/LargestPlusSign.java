package Practice.Recursion;

/*

You are given an integer n. You have an n x n binary grid grid with all values initially 1's except for some indices
given in the array mines. The ith element of the array mines is defined as mines[i] = [xi, yi] where grid[xi][yi] == 0.

Return the order of the largest axis-aligned plus sign of 1's contained in grid. If there is none, return 0.

An axis-aligned plus sign of 1's of order k has some center grid[r][c] == 1 along with four arms of length k - 1 going
up, down, left, and right, and made of 1's. Note that there could be 0's or 1's beyond the arms of the plus sign, only
the relevant area of the plus sign is checked for 1's.

 Input: n = 5, mines = [[4,2]]
Output: 2
Explanation: In the above grid, the largest plus sign can only be of order 2.

Brute force approach → uses dfs at every element
    Time Complexity: O(N^3)
Optimal approach → create left, right, top and bottom arrays instead of using dfs at every index
    Time Complexity: O(N^2)

 */

import java.util.Arrays;

public class LargestPlusSign {
    public static void main(String[] args) {
        System.out.println(orderOfLargestPlusSign(5, new int[][]{{4,2}}));
    }

    public static int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] mat = new int[n][n];
        for(int[] m: mat){
            Arrays.fill(m,1);
        }
        for(int[] m: mines){
            mat[m[0]][m[1]] = 0;
        }
        int[][] left = new int[n][n];
        int[][] right = new int[n][n];
        int[][] top = new int[n][n];
        int[][] bottom = new int[n][n];

        for(int i = 0; i<n; i++){
            left[i][0] = mat[i][0];
            for(int j = 1; j<n; j++){
                left[i][j] = mat[i][j]==0 ? 0 : left[i][j-1] +1;
            }
            right[i][n-1] = mat[i][n-1];
            for(int j = n-2; j>=0; j--){
                right[i][j] = mat[i][j]==0 ? 0 : right[i][j+1]+1;
            }
        }
        for(int j = 0; j<n; j++){
            top[0][j] = mat[0][j];
            for(int i = 1; i<n; i++){
                top[i][j] = mat[i][j]==0 ? 0 : top[i-1][j] + 1;
            }
            bottom[n-1][j] = mat[n-1][j];
            for(int i = n-2; i>=0; i--){
                bottom[i][j] = mat[i][j]==0 ? 0 : bottom[i+1][j] + 1;
            }
        }
        int max = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                max = Math.max(
                        max,
                        Math.min(
                                Math.min(left[i][j], right[i][j]),
                                Math.min(top[i][j], bottom[i][j])
                        )
                );
            }
        }
        return max;
    }
}
