package Day12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/*

https://leetcode.com/problems/combination-sum-ii/description/

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output:
[
[1,2,2],
[5]
]

 */
public class Combinations_Sum2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 7
        int[] arr = new int[n]; // 10 1 2 7 6 1 5
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt(); // 8
        System.out.println(combinationSum2(arr, k));
    }

    static List<List<Integer>> ans = new ArrayList < > ();

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        findCombinations(0, candidates, target, new ArrayList < > ());
        return ans;
    }
    public static void findCombinations(int ind, int[] arr, int target, List < Integer > ds) {
        if (target == 0) {
            ans.add(new ArrayList < > (ds));
            return;
        }

        for (int i = ind; i < arr.length; i++) {
            if (i > ind && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) break;

            ds.add(arr[i]);
            findCombinations(i + 1, arr, target - arr[i], ds);
            ds.remove(ds.size() - 1);
        }
    }

}
