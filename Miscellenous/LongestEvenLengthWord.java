package Miscellenous;

import java.util.Arrays;
import java.util.Scanner;

/*
Given a list of words seperated by space, print the first occurring longest even word with even length if no such word is present, print "00"

Input -> "This is a good event"
Output -> "This"
 */
public class LongestEvenLengthWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] list = str.split(" ");
        int evenMax = 0;
        String res = "00";
        for (String s : list) {
            if (s.length() % 2 == 0 && s.length() > evenMax) {
                evenMax = s.length();
                res = s;
            }
        }
        System.out.println(res);
    }
}
