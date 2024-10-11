package Miscellenous;

public class PanagramsCheck {
    public static void main(String[] args) {
        String[] arr = {"pack my box with five dozen liquor jugs", "this is not a panagram", "the quick brown fox jumps over the lazy dog"};
        StringBuilder sb = new StringBuilder();
        for(String s: arr){
            if(isPanagram(s)){
                sb.append("1");
            }else{
                sb.append("0");
            }
        }
        System.out.println(sb.toString());
    }

    public static boolean isPanagram(String str){
        boolean[] count = new boolean[26];
        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i)==' '){
                continue;
            }
            count[str.charAt(i) - 'a'] = true;
        }
        for(int i = 0; i<26; i++){
            if(!count[i]) {
                return false;
            }
        }
        return true;
    }
}
