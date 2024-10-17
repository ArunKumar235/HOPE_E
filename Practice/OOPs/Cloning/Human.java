package Practice.OOPs.Cloning;

public class Human implements Cloneable{ // Cloneable is a marker interface, marker interface has no methods
    int age;
    String name;
    int[] arr;

    public Human(int age, String name){
        this.age = age;
        this.name = name;
        this.arr = new int[]{1, 2, 3};
    }

    public Human(Human other){
        this.age = other.age;
        this.name = other.name;
        this.arr = other.arr;
    }


    // This is shallow copy
//    @Override
//    public Human clone() { // clone method is protected in Object class, so we need to override it
//        try {
//            // this is a shallow copy, if we have any reference type in the class, we need to make a deep copy
//            return (Human) super.clone();
//        } catch (CloneNotSupportedException e) {
//            System.out.println("Cloning not allowed.");
//        }
//        return null;
//    }


    // This is deep copy
    @Override
    public Human clone() {
        try {
            Human h = (Human) super.clone();
            h.arr = this.arr.clone(); // deep copy, a new object is created for the reference type, it works by creating a new object and copying the contents of the old object to the new object
            // equivalent to the following code
//            h.arr = new int[this.arr.length];
//            for(int i = 0; i < this.arr.length; i++){
//                h.arr[i] = this.arr[i];
//            }
            return h;
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning not allowed.");
        }
        return null;
    }
}