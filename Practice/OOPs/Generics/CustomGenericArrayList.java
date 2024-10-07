package Practice.OOPs.Generics;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomGenericArrayList<T> {

    private Object[] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0; // Also working as the index value

    public CustomGenericArrayList(){
        this.data = new Object[DEFAULT_SIZE];
    }

    public void add(T num){
        if(isFull()){
            resize();
        }
        data[size++] = num;
    }

    private boolean isFull(){
        return size==data.length;
    }

    private void resize(){
        Object[] temp = new Object[data.length * 2];
        // Copy the preexisting data in data to temp
        for(int i = 0; i<data.length; i++){
            temp[i] = data[i];
        }
        data = temp;
    }

    public T remove(){
        T removed = (T)(data[--size]);
        return removed;
    }

    public T get(int index){
        return (T)data[index];
    }

    public int size(){
        return size;
    }

    public void set(int index, T value){
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
        CustomGenericArrayList<Integer> listIn = new CustomGenericArrayList<>();
        for(int i = 1; i<15; i++){
            listIn.add(i*2);
        }
        System.out.println(listIn);

        CustomGenericArrayList<Character> listStr = new CustomGenericArrayList<>();
        for(int i = 0; i<15; i++){
            listStr.add((char)('a'+i));
        }
        System.out.println(listStr);


    }
}