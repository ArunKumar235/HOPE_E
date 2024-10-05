package Practice.Recursion;

/*

Generate permutations of a string

permutations are about inserting elements at all different positions

           "" | abc
              |
             a|bc
          /        \
      ba|c          ab|c
     /  |  \      /   |  \
    cba bca bac  cab  acb abc

    for a string of length n, there are n! permutations possible

 */

public class Permutations {
    public static void main(String[] args) {
        String str = "abc";
        generatePermutations("", str);
    }

    public static void generatePermutations(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }
        char ch = unprocessed.charAt(0);
        for(int i = 0; i<=processed.length(); i++){
            String first = processed.substring(0,i);
            String second = processed.substring(i);
            generatePermutations(first+ch+second, unprocessed.substring(1));
        }
    }
}
