// The code in this file isn't the complete solution to the crossword problem
// I have implemented the code under few assumptions, that the minimum length of any word is two and also no two words are with same length
// I haven't used backtracking in this code, however I have implemented the logic to find the start point of a slot and whether it is a horizontal or vertical slot

package Day5;

import java.util.*;

/*

+-++++++++
+-++++++++
+-++++++++
+-----++++
+-+++-++++
+-+++-++++
+++++-++++
++------++
+++++-++++
+++++-++++
LONDON;DELHI;ICELAND;ANKARA


+L++++++++
+O++++++++
+N++++++++
+DELHI++++
+O+++C++++
+N+++E++++
+++++L++++
++ANKARA++
+++++N++++
+++++D++++

 */

public class CrossWord_Puzzle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = 10;
        int C = 10;
        List<String> crossword = new ArrayList<>();
        for(int i =0 ;i<R; i++){
            crossword.add(sc.next());
        }
        String words = sc.next();
        List<String> result = crosswordPuzzle(crossword, words);
        for (String s : result) {
            System.out.println(s);
        }
    }

    public static List<String> crosswordPuzzle(List<String> crossword, String words) {
        String[] keys = words.split("[;]");
        List<String> result = new ArrayList<>();
        int R = crossword.size();
        int C = crossword.get(0).length();
        char[][] grid = new char[R][C];
        for(int i = 0; i<R; i++){
            for(int j = 0; j<C; j++){
                grid[i][j] = crossword.get(i).charAt(j);
            }
        }
        printMatrix(grid);
        List<Slot> slots = new ArrayList<>();
        for(int row = 0; row <R; row++){
            for(int col = 0; col <C; col++){
                if(grid[row][col]=='+') continue;
                //Check if Vertical Start
                if(row==0 || grid[row-1][col]!='-'){
                    if(row+1 != R && grid[row+1][col]=='-'){
                        int len = 1;
                        int shift = 1;
                        while(row+shift<R && grid[row+shift][col]=='-'){
                            len++;
                            shift++;
                        }
                        slots.add(new Slot(row, col, len, false));
                    }
                }
                //Check if Horizontal
                if(col==0 || grid[row][col-1]!='-'){
                    if(col+1 !=C  && grid[row][col+1]=='-'){
                        int len = 1;
                        int shift = 1;
                        while(col+shift<C && grid[row][col+shift]=='-'){
                            len++;
                            shift++;
                        }
                        slots.add(new Slot(row, col, len, true));
                    }
                }
            }
        }
        printAllSlots(slots);
        HashMap<Integer, List<String>> lenCounter = new HashMap<>();
        for(String key: keys){
            if(lenCounter.containsKey(key.length())){
                lenCounter.get(key.length()).add(key);
            }else{
                List<String> counts = new ArrayList<>();
                counts.add(key);
                lenCounter.put(key.length(), counts);
            }
        }
        System.out.println(lenCounter);
        for(int len: lenCounter.keySet()){
            if(lenCounter.get(len).size()==1){
                for(Slot s: slots){
                    if(s.length==len){
                        placeString(s, lenCounter.get(len).get(0), grid);
                    }
                }
            }
        }
        printMatrix(grid);
        return result;

    }

    public static void placeString(Slot s, String str, char[][] grid){
        boolean isHor = s.isHor;
        int x = 0;
        if (isHor){
            for(int j = s.stCol; j<s.stCol+s.length; j++){
                grid[s.stRow][j] = str.charAt(x++);
            }
        }else{
            for(int i = s.stRow; i<s.stRow+s.length; i++){
                grid[i][s.stCol] = str.charAt(x++);
            }
        }
    }

    public static void printAllSlots(List<Slot> slots){
        for(Slot s: slots){
            System.out.println(s.stRow+" "+s.stCol+" "+s.isHor+" "+s.length);
        }
    }

    public static void printMatrix(char[][] grid){
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
}

class Slot{
    int stRow;
    int stCol;
    int length;
    boolean isHor;

    public Slot(int stRow, int stCol, int length, boolean isHor) {
        this.stRow = stRow;
        this.stCol = stCol;
        this.length = length;
        this.isHor = isHor; // true for horizontal slots and false for vertical slots
    }
}