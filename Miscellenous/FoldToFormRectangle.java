package Miscellenous;

import java.util.Scanner;

/*
Given a rectangular paper of size h*w, return the minimum number of folds required to form a new rectangle of size h1*w1
input -> h w h1 w1

Test Case 1

input -> 8 4  6  2
output ->   3


Test Case 2

input -> 3 2  2  2
output ->  1


Test Case 2

input -> 10 10  1  1
output ->  6
 */

public class FoldToFormRectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int h1 = sc.nextInt();
        int w1 = sc.nextInt();
        int foldCount = 0;
        while(h>h1){
            h += (h%2);
            h/=2;
            foldCount++;
        }
        while(w>w1){
            w += (w%2);
            w/=2;
            foldCount++;
        }
        System.out.println(foldCount);
    }
}


