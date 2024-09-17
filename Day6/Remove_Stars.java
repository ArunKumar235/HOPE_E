package Day6;

import java.util.*;

public class Remove_Stars {
    public static void main(String[] args) {
        String s = "leet**cod*e";
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<s.length(); i++){
            if(s.charAt(i)=='*' && !sb.isEmpty()){
                sb.deleteCharAt(sb.length()-1);
            }else{
                sb.append(s.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }
}
