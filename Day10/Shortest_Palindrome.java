package Day10;

import java.util.Scanner;

/*
https://leetcode.com/problems/shortest-palindrome/description/

You are given a string s. You can convert s to a
palindrome by adding characters in front of it.

Return the shortest palindrome you can find by performing this transformation.

Example 1:

Input: s = "aacecaaa"
Output: "aaacecaaa"
Example 2:

Input: s = "abcd"
Output: "dcbabcd"

Solution LPS Approach{
  Create a new string by appending reversed string seperated by a '_'
  find the lps array for that string
  the last value of lps represents the length of the largest prefix that is a palindrome
  so append the reversed value of remaining substring to the front and thus it becomes a palindrome

   aacecaaa
   a  a  c  e  c  a  a  a  _  a  a  a  c  e  c  a  a
  [0, 1, 0, 0, 0, 1, 2, 2, 0, 1, 2, 2, 3, 4, 5, 6, 7]
  aacecaa | a => a | aacecaaa | a
  the substring that is not a palindrome is (7,s.length())
  so the result is reversed non-palindromic substring + orginal string -> (a) + (aacecaa) + (a)
  abcd
  a b c d _ d c b a
 [0 0 0 0 0 0 0 0 1]
 a | bcd => dcb | a | bcd
}

Solution Recursive Approach{
  Finding the longest common palindromic subsequence,
  among the string and reverse of that string

  org: a a c e c a a a
       | |  \ \ \ \ \
  rev: a a a c e c a a

  (   aacecaa  | a )
  ( a | aacecaa | a )

  org: a a c e c a a
       | | | | | | |
  rev: a a c e c a a

}

 */

public class Shortest_Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(shortestPalindrome_UsingLPS(s));
        System.out.println(Shortest_Palindrome_UsingRecursion(s));
    }

    public static String shortestPalindrome_UsingLPS(String s) {
        int len = s.length();
        s = s + '_' + new StringBuilder(s).reverse().toString();
        int[] lps = new int[s.length()];
        int streakIndex = 0;
        for (int index = 1; index < s.length(); ) {
            if (s.charAt(streakIndex) == s.charAt(index)) {
                lps[index] = streakIndex + 1;
                index++;
                streakIndex++;
            } else {
                if (streakIndex != 0) {
                    streakIndex = lps[streakIndex - 1];
                } else {
                    lps[index] = 0;
                    index++;
                }
            }
        }
        int l = lps[lps.length - 1];
        String org = s.substring(0, len);
        return new StringBuilder(org.substring(l)).reverse().toString() + org;
    }

    public static String Shortest_Palindrome_UsingRecursion(String s){
        return helper(s);
    }

    public static String helper(String s){
        int left = 0;
        int right = s.length()-1;
        while(left<s.length() && right>=0){
            while(right>=0 && s.charAt(left)!=s.charAt(right)){
                right--;
            }
            left++;
            right--;
            System.out.println(left+" "+right);
        }
        if(left==s.length()){
            return s;
        }else{
            String sub = s.substring(left);
            return new StringBuilder(sub).reverse().toString() + helper(s.substring(0,left)) + sub;
        }
    }
}