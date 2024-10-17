package Practice.OOPs.Collections;

import java.util.Iterator;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {

//        Vector uses a dynamic array to store the data elements. It is similar to ArrayList.
//        However, It is synchronized and contains many methods that are not part of the Collection framework.
//        Synchronized means only one thread can access the code at a time, so it is thread safe.
//        ArrayList is not synchronized, so multiple threads can access the code at the same time, so it is not thread safe.

        Vector<String> v = new Vector<String>();
        v.add("Ayush");
        v.add("Amit");
        v.add("Ashish");
        v.add("Garima");
        Iterator<String> itr = v.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
