package Practice.OOPs.Generics;

import java.util.Arrays;

public class CustomArrayList {

    private int[] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0; // Also working as the index value

    public CustomArrayList(){
        this.data = new int[DEFAULT_SIZE];
    }

    public void add(int num){
        if(isFull()){
            resize();
        }
        data[size++] = num;
    }

    private boolean isFull(){
        return size==data.length;
    }

    private void resize(){
        int[] temp = new int[data.length * 2];
        // Copy the preexisting data in data to temp
        for(int i = 0; i<data.length; i++){
            temp[i] = data[i];
        }
        data = temp;
    }

    public int remove(){
        int removed = data[--size];
        return removed;
    }

    public int get(int index){
        return data[index];
    }

    public int size(){
        return size;
    }

    public void set(int index, int value){
        data[index] = value;
    }

    @Override
    public String toString(){
        return "CustomArrayList{" +
                "data = " + Arrays.toString(data) +
                ", size = " + size +
                "}";
    }

//    @Override
//    public void finalize(){
//        System.out.println("Garbage Collection hits!");
//    }

    public static void main(String[] args) {
        CustomArrayList list = new CustomArrayList();
        for(int i = 1; i<15; i++){
            list.add(i*2);
        }
        System.out.println(list);
    }
}
