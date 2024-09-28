package Day12;

import java.util.Scanner;

/*

https://leetcode.com/problems/trapping-rain-water/description/

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6

Solution{
0 + (0-0)l + (1-1)l + (1-0)l + (1-1)r + (2-2)l + (2-1)l + (2-0)l + (2-1)l + (2-2)r + (2-1)r + (2-2)r
0 +   0    +   0    +   1    +   0    +   0    +   1    +   2    +   1    +   0    +   1    +    0     ==      6
}

Input: height = [4,2,0,3,2,5]
Output: 9


 */
public class Trapping_Rain_Water {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 12
        int[] arr = new int[n]; // 0 1 0 2 1 0 1 3 2 1 2 1
        for(int i = 0 ; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(trap(arr));
    }

    public static int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int leftMax = height[0];
        int rightMax = height[height.length-1];
        int trappedWater = 0;
        while(left<right){
            if(leftMax<=rightMax){
                trappedWater += leftMax-height[left];
                left++;
                leftMax = Math.max(leftMax, height[left]);
            }else{
                trappedWater += rightMax-height[right];
                right--;
                rightMax = Math.max(rightMax, height[right]);
            }
        }
        return trappedWater;
    }
}
