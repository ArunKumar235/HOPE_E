package Miscellenous;

import java.util.Arrays;
/*
print the minimum number of characters needed to be changed to convert b[i] to a[i], return -1 if not possible
 */
public class AnangramDifference {
    public static void main(String[] args) {
        String[] a = {"a", "jk", "abb", "mn", "abc"};
        String[] b = {"bb", "kj", "bbc", "op", "def"};
        int[] res = new int[a.length];
        for(int i = 0; i<res.length; i++){
            res[i] = isAnagram(a[i],b[i]);
        }
        System.out.println(Arrays.toString(res)); // -1 0 1 2 3
    }

    public static int isAnagram(String a, String b){
        if(a.length()!=b.length()) return -1;
        int[] count = new int[26];
        int sum = 0;
        for(int i = 0; i<a.length(); i++){
            count[a.charAt(i)-'a']++;
            count[b.charAt(i)-'a']--;
        }
        for(int i = 0; i<count.length; i++){
            sum += (count[i] > 0) ? count[i] : 0;
        }
        return sum;
    }
}
