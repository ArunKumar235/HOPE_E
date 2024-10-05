package Practice.Recursion;

/*

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        generateCombinations(digits, 0, sb, result, map);
        return result;
    }

    public static void generateCombinations(String digits, int index, StringBuilder sb, List<String> result, HashMap<Character, String> map){
        if(sb.length()==digits.length()){
            result.add(sb.toString());
            return ;
        }
        char d = digits.charAt(index);
        String val = map.get(d);
        for(int i = 0; i<val.length(); i++){
            sb.append(val.charAt(i));
            generateCombinations(digits, index+1, sb, result, map);
            sb.setLength(sb.length()-1);
        }
    }
}
