package Practice;

/*
    Generate all subsequence of the string
    The pattern of taking some elements and removing some is known as the subset pattern

               ""|abc
              /       \
        ""|bc          a|bc
         /   \        /    \
     ""|c    b|c     a|c   ab|c
      / \     /  \   /  \    / \
    ""   c    b  bc  a  ac  ab  abc

 */

public class SubSequence {
    public static void main(String[] args) {
        subseq("","abc");
    }

    public static void subseq(String p, String up){
        if(up.isEmpty()){
            System.out.print(p+" ");
            return;
        }
        char ch = up.charAt(0);
        subseq(p, up.substring(1));
        subseq(p+ch, up.substring(1));
    }
}
