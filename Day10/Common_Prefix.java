package Day10;

import java.util.Arrays;
import java.util.Scanner;
/*

Print the length of the longest common prefix among the given strings

geeksgeekgeeks
geek

op-> 3


abaabbaabaab
abaa

op-> 2

 */
public class Common_Prefix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next(); // geeksgeekgeeks
        String key = sc.next(); // geek
        int[] lps = new int[key.length()];
        int streakindex = 0;
        for (int index = 1; index < key.length(); ) {
            if (key.charAt(index) == key.charAt(streakindex)) {
                lps[index] = streakindex+1;
                streakindex++;
                index++;
            } else {
                if (streakindex != 0) {
                    streakindex = lps[streakindex - 1];
                } else {
                    lps[index] = 0;
                    index++;
                }
            }
        }
        int keyIndex = 0;
        int count = 0;
        for(int index = 0; index<str.length(); ){
            if(str.charAt(index)==key.charAt(keyIndex)){
                index++;
                keyIndex++;
                if(keyIndex ==key.length()){
                    count++;
                    keyIndex = 0;
                }
            }else{
                if(keyIndex ==0){
                    index++;
                }else{
                    keyIndex =lps[keyIndex -1];
                }
            }
        }
        System.out.println(Arrays.toString(lps));
        System.out.println(count);
    }
}
