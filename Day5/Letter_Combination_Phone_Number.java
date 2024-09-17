package Day5;

import java.util.*;

public class Letter_Combination_Phone_Number {

    static Map<Character, String> letterMap = Map.of(
            '2', "abc",
            '3', "def",
            '4', "ghi",
            '5', "jkl",
            '6', "mno",
            '7', "pqrs",
            '8', "tuv",
            '9', "wxyz"
    );

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String digits = sc.next(); // "23"

        System.out.println(letterCombinations(digits)); // [ad, ae, af, bd, be, bf, cd, ce, cf]

    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.isEmpty()) return result;
        StringBuilder sb = new StringBuilder();
        solve(digits, 0, sb, result);
        return result;
    }

    public static void solve(String digits, int index, StringBuilder sb, List<String> result){
        if(digits.length()==index){
            result.add(sb.toString());
            return;
        }
        String str = letterMap.get(digits.charAt(index));
        for(int i =0 ;i<str.length(); i++){
            sb.append(str.charAt(i));
            solve(digits, index+1, sb, result);
            sb.setLength(sb.length()-1);
        }
    }
}
