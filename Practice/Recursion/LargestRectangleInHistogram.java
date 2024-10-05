package Practice.Recursion;

import java.util.Stack;

/*
https://leetcode.com/problems/largest-rectangle-in-histogram/description/


Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
return the area of the largest rectangle in the histogram.


Example 1:
Input: heights = [2,1,5,6,2,3]
Output: 10


Example 2:
Input: heights = [2,4]
Output: 4

Brute force Approach → Using substring method
    Time complexity: O(N^2)
    Space complexity: O(1)
Optimal Approach → Using stack to find the next smaller element(nse), and previous smaller element(pse)
    Time complexity: O(N)
    Space complexity: O(N)

 */


public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {
        Stack<block> stack = new Stack<>();
        int maxArea = heights[0];
        for(int idx = 0; idx<heights.length; idx++){
            int start = idx;
            while (!stack.isEmpty() && heights[idx]<stack.peek().height){
                block prev = stack.pop();
                start = prev.index;
                maxArea =  Math.max((idx- prev.index) * prev.height, maxArea);
            }
            stack.push(new block(heights[idx], start));
        }
        while(!stack.isEmpty()){
            block prev = stack.pop();
            maxArea = Math.max(maxArea, prev.height*(heights.length - prev.index));
        }
        return maxArea;
    }
}

class block {
    int height, index;
    public block(int height, int index){
        this.height = height;
        this.index = index;
    }
}
