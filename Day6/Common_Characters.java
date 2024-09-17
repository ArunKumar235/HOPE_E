package Day6;

public class Common_Characters {
    public static void main(String[] args) {
        int n = 5;
        String[] arr = {"giraffe", "fishery", "orangeisland", "magnetism", "engine"};
        commonChar_BitwiseApproach(arr); // ei -> only ei is common in all the strings
        System.out.println();
        commonChar_arrayApproach(arr); // // ei -> only ei is common in all the strings
        System.out.println();
        commonChar_In_Atleast_N_1_Strings(arr); // egi -> g is present in all strings except fishery, ei is present in all strings
    }
    public static void commonChar_BitwiseApproach(String[] arr){

        int res = (1<<'z'-'a'+2)-1;
        for(String str : arr){
            int charPresent = 0;
            for(int i = 0; i< str.length(); i++){
                charPresent |= (1<<(str.charAt(i)-'a'));
            }
//            j |= (1<<'z'-'a'+1);
//            System.out.println(Integer.toBinaryString(j));
            res &= charPresent;
        }
//        System.out.println(Integer.toBinaryString(x));
        int shift = 0;
        while(res !=0){
            if((res &1)!=0){
                System.out.print((char)(shift+'a'));
            }
            shift++;
            res >>=1;
        }
    }

    public static void commonChar_arrayApproach(String[] arr){
        int[] ascii = new int[128];
        for(int idx = 0; idx <arr.length; idx++){
            for(int charidx = 0; charidx <arr[idx].length(); charidx++){
                char ch = arr[idx].charAt(charidx);
                if(ascii[ch]== idx){
                    ascii[ch]++;
                }
            }
        }
        for(int i = 0; i<ascii.length; i++){
            if(ascii[i] == arr.length){
                System.out.print((char)i);
            }
        }
    }
    public static void commonChar_In_Atleast_N_1_Strings(String[] arr){
        int[] ascii = new int[128];
        for(int idx = 0; idx <arr.length; idx++){
            int[] ascii_inCurrent = new int[128];
            for(int charidx = 0; charidx<arr[idx].length(); charidx++){
                char ch = arr[idx].charAt(charidx);
                ascii_inCurrent[ch]++;
                if(ascii_inCurrent[ch]==1){
                    ascii[ch]++;
                }
            }
        }
        for(int i = 0; i<ascii.length; i++){
            if(ascii[i] == arr.length || ascii[i] == arr.length-1){
                System.out.print((char)i);
            }
        }
    }
}
