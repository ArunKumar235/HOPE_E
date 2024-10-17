package Practice.OOPs.Cloning;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Human h1 = new Human(19, "Arun");

        //Shallow copy - only the references are copied, not the actual objects, so if we change the object in one class, it will reflect in the other class as well
        // change in primitive types will not reflect in the other class
        // change in reference types will reflect in the other class

//        Human h2 = new Human(h1);
//        Human h3 = h1.clone(); // efficient than using a copy constructor, as it doesn't require a new object to be created
//        h1.arr[0] = 100;
//        System.out.println(h1.age + " " + h1.name + " " + Arrays.toString(h1.arr));
//        System.out.println(h2.age + " " + h2.name + " " + Arrays.toString(h2.arr));
//        System.out.println(h3.age + " " + h3.name + " " + Arrays.toString(h3.arr));




        // Deep copy - new objects are created for the reference types, so if we change the object in one class, it will not reflect in the other class
        // change in primitive types will not reflect in the other class
        // change in reference types will not reflect in the other class

        Human h4 = h1.clone();
        h1.arr[0] = 100;
        System.out.println(h1.age + " " + h1.name + " " + Arrays.toString(h1.arr));
        System.out.println(h4.age + " " + h4.name + " " + Arrays.toString(h4.arr));

    }
}
