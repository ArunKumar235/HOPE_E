package Day11;

import java.util.Arrays;
import java.util.Scanner;

/*

https://leetcode.com/problems/distinct-subsequences/description/


Given two strings s and t, return the number of distinct subsequences of s which equals t.

Input: s = "rabbbit", t = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from s.
rabb(b)it
rab(b)bit
ra(b)bbit

Input: s = "baat", t = "bat"
Output: 2
Explanation:
As shown below, there are 2 ways you can generate "bat" from s.
ba(a)t
b(a)at
                        [baat ,bat]
                    /                  \
            [baa,ba]                     [baa,bat]
         /           \                       |
    [ba,b]          [ba,ba]               [ba,bat]
      |            /       \                 |
     [b,b]       [b,ba]    [b,b]           [b,bat]
   /       \      |        /    \            |
['', b] ['','']  ['',ba] ['',b] ['','']    ['',bat]
            |                      |
            +1                     +1

if the last character in both strings is matching, then there are two possibles,
remove the last character from both the strings or remove the last character in the first string and search for any other possible matches

if the last characters didn't match, then remove the last character from the first string and continue searching

if the second string becomes empty, then there is a match found

Since repeated problems are solved, again and again, use a 2d matrix to memoize

 */
public class Distinct_Subsequences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next(); // rabbbit
        String t = sc.next(); // rabbit

        System.out.println(numDistinct(s,t));
    }
    public static int numDistinct(String s, String t){
        int[][] dp = new int[s.length()][t.length()];
        for(int i = 0; i<s.length(); i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(dp,s,t,s.length()-1,t.length()-1);
    }
    public static int helper(int[][] dp, String s, String t, int row, int col){
        if(col==-1){
            return 1;
        }if(row==-1){
            return 0;
        }if(dp[row][col]!=-1){
            return dp[row][col];
        }
        if(s.charAt(row)==t.charAt(col)){
            dp[row][col] = helper(dp,s,t,row-1,col) + helper(dp,s,t,row-1,col-1);
        }else{
            dp[row][col] = helper(dp,s,t,row-1, col);
        }
        return dp[row][col];
    }
}
