package Practice;

/*
Given a dice, and a target k, print all the possible ways to obtain the sum k, by throwing dice multiple times

target → 4
output → [1111, 112, 121, 13, 211, 22, 31, 4]

 */

import java.util.ArrayList;
import java.util.List;

public class DiceThrowToGetSumK {
    public static void main(String[] args) {
        int target = 4;
        System.out.println(obtainSum(target));
    }

    public static List<List<Integer>> obtainSum(int target){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        generateCombination(target, li, result);
        return result;
    }

    public static void generateCombination(int target, List<Integer> li, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(li)); // Add a new instance of li to result
            return;
        }
        for(int i = 1; i <= 6 && i <= target; i++){
            li.add(i);
            generateCombination(target - i, li, result);
            li.remove(li.size() - 1); // Remove the last element added for backtracking
        }
    }
}
