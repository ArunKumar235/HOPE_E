package Day8;

import java.util.Scanner;

/*
Given an array of wine bottles arranged in a line, denoting its prices
Each year you can either sell a bottle at left or a bottle from right, but you must sell 1 bottle every year
3 5 7 3 6
the prices of bottle increases every year, with respect to the original price
In 1st year you can sell either 3 or 6
suppose you sell 3 in 1st year, you earn 3*1
you are left with 5 7 3 6, if you sell 6 you earn 6*2
you are left with 5 7 3,  if you sell 3 you earn 3*3
you are left with 5 7,  if you sell 5 you earn 5*4
you are left with 7, if you sell you 7 earn 7*5
therefore the max you can earn is 79

                          3 5 7 3 6
                  /                        \
            5 7 3 6                         3 5 7 3
          /         \                     /         \
      7 3 6          5 7 3            3 5 7          5 7 3
    /     \        /       \         /    \         /     \
   3 6    7 3    7 3       5 7     5 7    3 5     7 3     5 7
  /  \    /  \  /  \       /  \   /   \   /  \   /   \    /  \
  3   6  7   3  7  3      5   7   5   7   3  5   7   3   5   7


here there are multiple repeated terms, so we go for memoization to reduce time complexity
you can generate maxRevenue by selling in the order of  1*3  + 2*6 + 3*3 + 4*5  + 5*7 = 79
here the code won't work if you sell just by considering the minimum value of left or right


5
3 5 7 3 6

op -> 79



 */
public class Selling_Wine_Bottles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] prices = new int[N];
        for(int i = 0; i<N; i++){
            prices[i] = sc.nextInt();
        }
        int[][] max = new int[N][N];
        System.out.println(maxRevenue(prices, max, 0,  N-1, 1));
    }


    public static int maxRevenue(int[] prices, int[][] max, int left, int right, int year){
        if(max[left][right]!=0){
            return max[left][right];
        }
        if(left==right) {
            return prices[left] * year;
        }
        int leftRevenue = prices[left]*year + maxRevenue(prices, max, left+1, right, year+1);
        int rightRevenue = prices[right]*year + maxRevenue(prices, max, left, right-1, year+1);
        max[left][right] = Math.max(leftRevenue,rightRevenue);
        return max[left][right];
    }
}
