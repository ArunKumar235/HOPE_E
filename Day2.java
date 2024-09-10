import java.util.Scanner;

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


//        HCF of two numbers using Euclidian Algorithm
        int m = sc.nextInt();
        int n = sc.nextInt();
        hcf(m,n);

    }

    public static void hcf(int m, int n){
        while(m!=0 && n!=0){
            int temp = m%n;
            n = n%m;
            m = temp;
        }
        System.out.println((m==0) ? n : m);
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
