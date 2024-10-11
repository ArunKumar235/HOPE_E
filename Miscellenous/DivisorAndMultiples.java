package Miscellenous;

import java.util.*;

public class DivisorAndMultiples {
    public static void main(String[] args) {
        int n = 5;
        int[] arr = {1,3,4,2,6};
        Set<Integer> nums = new HashSet<>();
        for (int j : arr) {
            nums.add(j);
        }
        Map<Integer, Integer> factorsMap = new HashMap<>();
        int[] res = new int[n];
        // Divisors check
        for(int i = 0; i<n; i++){
            List<Integer> factorList = factors(arr[i]);
            for(int fact : factorList){
                if(factorsMap.containsKey(fact)){
                    factorsMap.replace(fact, factorsMap.get(fact)+1);
                }else{
                    factorsMap.put(fact,1);
                }
                if(nums.contains(fact)){
                    res[i]++;
                }
            }
            res[i]--;
        }
        System.out.println(Arrays.toString(res));
        // Multiples check
        for(int i = 0; i<n; i++){
            res[i] += factorsMap.get(arr[i])-1;
        }
        System.out.println(Arrays.toString(res));
    }

    public static List<Integer> factors(int n){
        List<Integer> factor = new ArrayList<>();
        for(int i = 1; i*i <=n; i++){
            if(i*i==n){
                factor.add(i);
            }else if(n%i==0){
                factor.add(i);
                factor.add(n/i);
            }
        }
        return factor;
    }
}