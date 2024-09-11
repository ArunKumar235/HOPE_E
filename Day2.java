import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Day2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

//        Give the binary representation of a number
//        binaryRepresentationReversed(10);


//         Check if all the alphabets from a...z are present in the string, using bitwise operators and no data structure
//        String s = sc.next(); // qwertyuiopasdfghjklzxcvbnmarunkumar -> Yes // uiopasdfghjklzxcvbnmarunkumar -> No
//        checkAllCharArePresent(s);


//        Check all digits are present
//        String num = sc.next(); // 12345678900987654321 -> Yes // 1234567812345678 -> No
//        checkAllDigitsArePresent(num);


//        Minimum Number of bits that need to be toggled so that both the numbers are equal
//        int m = sc.nextInt(); // 16 - 10000
//        int n = sc.nextInt(); // 17 - 10001
//        toggleCount(m,n); // 1 bit need to be toggled so that both num are same


//        HCF of two numbers using Euclidean Algorithm
//        int m = sc.nextInt();
//        int n = sc.nextInt();
//        System.out.println(hcf(m,n));


//        find the only term which is repeated odd number of times
//        int n = sc.nextInt(); // 5
//        int[] arr = new int[n]; // 3 5 7 7 3
//        for(int i = 0; i<n; i++){
//            arr[i] = sc.nextInt();
//        }
//        checkForOddRepeatedTerm(arr); // 5


//        Find the two odd number of repeated terms
//        int n = sc.nextInt(); // 12
//        int[] arr = new int[n]; // 5 6 5 7 4 4 25 25 25 25 30 30 - 3 5 6 6 4 3
//        for(int i = 0; i<n; i++){
//            arr[i] = sc.nextInt();
//        }
//        oddOccurrenceNumbers(arr); // 6 7 - 4 5


//        Remove adjacent elements from Array
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for(int i = 0; i<n; i++){
//            arr[i] = sc.nextInt();
//        }
//        removeAdjacent(arr);


//        Print all the combinations of a String
//        String str = sc.next(); // abcd
//        combinations(str);


//        Number of subarray whose sum is k
//        int n = sc.nextInt(); // 9
//        int[] arr = new int[n]; // 3 3 2 4 4 2 3 2 1
//        for(int i = 0; i<n; i++){
//            arr[i] = sc.nextInt();
//        }
//        int k = sc.nextInt(); // 6
//        subArraySumK(arr,k); // 4


//        Maximum length of subarray with equal number of ones and zeros
//        String num = sc.next();
//        maxLenWithEqual01(num);


//        print N characters of a string
//        int n = sc.nextInt();
//        String str = sc.next();
//        printRepeatedly(str, n);
    }

    public static void printRepeatedly(String str, int n){
        for(int i = 0; i<n/str.length(); i++){
            System.out.print(str);
        }
        for(int i = 0; i<n%str.length(); i++){
            System.out.print(str.charAt(i));
        }
    }

    public static void maxLenWithEqual01(String num){
        HashMap<Integer, Integer> map = new HashMap<>();
        int counter = 0;
        int maxLen = 0;
        map.put(0,0);
        for(int idx = 0; idx<num.length(); idx++){
            if(num.charAt(idx)=='1'){
                counter++;
            }else{
                counter--;
            }
            if(map.containsKey(counter)){
                maxLen = Math.max(idx - map.get(counter), maxLen);
            }else{
                map.put(counter, idx);
            }
        }
        System.out.println(map);
        System.out.println(maxLen);
    }

    public static void subArraySumK(int[] arr, int k){
        int left = 0;
        int right = 0;
        int currSum = 0;
        int count = 0;
        while (right < arr.length){
            if(currSum == k){
                count++;
                currSum -= arr[left];
                left++;
            }else if(currSum < k){
                currSum+=arr[right++];
            }else{
                currSum-=arr[left++];
            }
        }
        if(currSum==k) count++;
        System.out.println(count);
    }

    public static void combinations(String str){
        int len = str.length();
        for(int ctr = 1; ctr< (1<<len); ctr++){
            for(int shift = 0; shift<len; shift++){
                if((ctr&(1<<shift)) != 0){
                    System.out.print(str.charAt(shift));
                }
            }
            System.out.println();
        }
    }

    public static void removeAdjacent(int[] arr){
        Stack<Integer> st = new Stack<>();
        for(int curr: arr){
            if(!st.isEmpty() && st.peek() == curr){
                st.pop();
            }else{
                st.push(curr);
            }
        }
        printStack(st);
    }

    public static void printStack(Stack<Integer> st){
        if(st.isEmpty()){
            return;
        }
        int val = st.pop();
        printStack(st);
        System.out.print(val+" ");
    }

    public static void oddOccurrenceNumbers(int[] arr){
        int res=0;
        for (int i : arr) {
            res = res ^ i;
        }
        int shift = 0;
        while((res&(1<<shift))==0){ // loop to find the first location of 1 in the binary representation of res, if res = 10 (1010 & 0001 = 0, 1010 & 0010 = 0010 != 0 -> shift = 1)
            shift++;
        }
        int zerosGrp = 0;
        int onesGrp = 0;
        for (int i : arr) {
            if((i&(1<<shift))!=0){ // check if the bit at shift location is 0 or 1 ( 5-> 101 & 010 = 000 -> 0, 6-> 110 & 010 = 010 -> 2)
//                System.out.print(i+"z ");
                zerosGrp = zerosGrp ^i; // XOR group where bit is 0
            }else{
//                System.out.print(i+"o ");
                onesGrp = onesGrp ^i; // XOR group where bit is 1
            }
        }
        System.out.println(zerosGrp +" "+ onesGrp);
    }

    public static void checkForOddRepeatedTerm(int[] arr) {
        int xor = 0;
        for(int i: arr){
            xor = i^xor;
        }
        System.out.println(xor);
    }

    public static int hcf(int m, int n){
        if(n==0){ // return the non-zero term
            return m;
        }
        return hcf(n, m%n); // Swap a with b, and b with a%b
    }

    public static void toggleCount(int m, int n) {
        int diff = m^n; // xor operation gives 1 if different and 0 if same
        int diffCounter = 0;
        while(diff!=0){ // loop to count the number of 1s in binary representation of diff, using Brian's Algorithm
            diff = diff & (diff-1);
            diffCounter ++;
        }
        System.out.println(diffCounter);

//        int toggleCount = 0;
//        while(m!=n){
//            if((m&1) != (n&1)){
//                toggleCount++;
//            }
//            m=m>>1;
//            n=n>>1;
//        }
//        System.out.println(toggleCount);
    }

    public static void checkAllDigitsArePresent(String num) {
        int result = 0;
        for(int i = 0; i<num.length(); i++){
            result = result | (1<<(num.charAt(i) - '0'));
        }
        System.out.println(Integer.toBinaryString(result)); // result = 0000001111 for num = 1230
        System.out.println(result==(1<<10)-1 ? "Yes" : "No"); // checks if result ==  1111111111
    }

    public static void checkAllCharArePresent(String s){
        int result = 0;
        for(int i = 0 ;i<s.length(); i++) {
            result = result | (1 << (s.charAt(i) - 'a')); // 1 is right shifted 0 times for 'a', 1 times for 'b' ... , 25 times for z
        }
        System.out.println(result == ((1<<26)-1) ? "Yes" : "No"); // checks i result contains 26 continuous 1s
    }

    public static void binaryRepresentationReversed(int n){
        for(int shift = 0; shift<=30; shift++){
            if((n&(1<<shift)) != 0){
                System.out.print(1);
            }else{
                System.out.print(0);
            }
        }
    }
}
