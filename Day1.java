import java.util.*;

public class Day1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        Accept an integer and print in its binary form
//        int num = sc.nextInt();
//        toBinary(num);


//        Print from 1 to N -> tail recursion
//        int num = sc.nextInt();
//        oneToN(num);


//        Print from N to 1 -> head recursion
//        int num = sc.nextInt();
//        nToOne(num);


//        Check if c is a combination of continuous substring of a and b
//        String a = sc.next(); // NOSE
//        String b = sc.next(); // NECK
//        String c = sc.next(); // NO N SE ECK - true  lNO CKNESE - false
//        boolean bool = false;
//        if(a.length()+b.length() == c.length()){
//            bool = validCombination(0,0,0,a,b,c);
//        }
//        System.out.println(bool);


//        Accept n number of positions of houses from the origin, accept the range of an antenna, and find the minimum number of antennas required to cover all the houses
//        int n = sc.nextInt(); // 7
//        int[] arr = new int[n]; // 2 4 5 6 9 11 15
//        for(int i=0; i<n; i++){
//            arr[i] = sc.nextInt();
//        }
//        int coverage = sc.nextInt(); // 2
//        Arrays.sort(arr);
//        System.out.println(minimumNoOfAntenna(arr, coverage)); // 3 -> first antenna is placed at 4 and covers (2,4,5,6) antennas, second antenna can be placed at 9 or 11 and covers (9, 11), third antenna is placed at 15 and covers (15)


//        House Robber - rob the max from colony without alerting police (robbing from adjacent houses alters police)
//        int n = sc.nextInt(); // 4
//        int[] arr = new int[n]; // 10 5 100 200
//        for(int i=0; i<n; i++){
//            arr[i] = sc.nextInt();
//        }
//        System.out.println(maxRobValue(arr)); // House robber


//        House Robber sum with modification - adjacent elements can be robbed if they are in same parity
//        int n = sc.nextInt(); // 9
//        int[] arr = new int[n]; // 10 5 15 25 900 600 700 50 15
//        for(int i=0; i<n; i++){
//            arr[i] = sc.nextInt();
//        }
//        System.out.println(maxRobValueParityModified(arr)); // 2275  // House robber - adjacent houses can be robbed if they are in same parity


//        Set bits - find number of 1s in its binary representation
//        int n  = sc.nextInt();
//        System.out.println(setbits(n));


//        Set bits Using Brians Algorithm - Optimal way
//        int n = sc.nextInt();
//        System.out.println(setbitsBrian(n));
    }

    public static int setbitsBrian(int n) {
        int count = 0;
        while(n!=0){
            n = n&(n-1);
            count++;
        }
        return count;
    }

    public static int setbits(int n) { // Count the number of 1s in its binary form
        int noOf1 = 0;
        while(n!=0){
            noOf1 += n&1;
            n = n>>1;
        }
        return noOf1;
    }

    public static int maxRobValueParityModified(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = (arr[0]%2==arr[1]%2) ? arr[0]+arr[1] : Math.max(arr[0], arr[1]);
        for(int i = 2; i<arr.length; i++){
            if(arr[i]%2==arr[i-1]%2){
                dp[i] = Math.max(dp[i-1]+arr[i], dp[i-2]+arr[i]);
            }else{
                dp[i] = Math.max(dp[i-1], dp[i-2]+arr[i]);
            }
        }
        return dp[arr.length-1];
    }


    public static int maxRobValue(int[] arr) { // 10 5 100 200
        int[] dp = new int[arr.length];        // 10 10 110 210
        dp[0] = arr[0];
        dp[1] = Math.max(dp[0],arr[1]);
        for(int i = 2; i<arr.length; i++){
            dp[i] = Math.max(dp[i-2]+arr[i], dp[i-1]);
        }
        return dp[arr.length -1];
    }

    public static int minimumNoOfAntenna(int[] arr, int coverage){
        int totalAntenna = 1;
        int coverageStart = arr[0];
        int currAntennaPos = arr[0];
        for(int i = 0; i<arr.length; i++){
            if(arr[i]<=coverageStart+coverage){
                currAntennaPos = arr[i];
            }else if(arr[i]<=currAntennaPos+coverage){
                continue; // the house is in the right part of the antenna
            }else{
                currAntennaPos = arr[i];
                coverageStart = arr[i];
                totalAntenna++;
            }
        }
        return totalAntenna;
    }

    public static boolean validCombination(int i, int j, int k, String str1, String str2, String str3){
        if(k==str3.length()){
                return true;
        }

        if((i < str1.length() && str1.charAt(i)==str3.charAt(k))&&(j < str2.length() && str2.charAt(j)==str3.charAt(k))){
            if(validCombination(i+1, j, k+1, str1, str2, str3)){ // Backtracking
                return true;
            }else{
                return validCombination(i,j+1,k+1, str1, str2, str3);
            }
        }else if(i < str1.length() && str1.charAt(i)==str3.charAt(k)){
            return validCombination(i+1, j, k+1, str1, str2, str3);
        }else if(j < str2.length() && str2.charAt(j)==str3.charAt(k)){
            return validCombination(i,j+1,k+1, str1, str2, str3);
        } else{
            return false;
        }
    }
    public static void toBinary(int num){
        if(num<2){
            System.out.print(num);
            return;
        }
        toBinary(num/2);
        System.out.print(num%2);

    }

    public static void oneToN(int n){
        if(n==0){
            return;
        }
        oneToN(n-1);
        System.out.print(n+" ");
    }

    public static void nToOne(int n){
        if(n==0){
            return;
        }
        System.out.print(n+" ");
        nToOne(n-1);
    }

}
