package Practice.OOPs.Generics.Comparing;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(1, 96);
        Student s2 = new Student(2, 69);
        Student s3 = new Student(3, 100);
        Student s4 = new Student(4, 45);

        if(s1.compareTo(s2) > 0){
            System.out.println("s1 scored more marks");
        }else if(s1.compareTo(s2) < 0){
            System.out.println("s2 scored more marks");
        }else{
            System.out.println("Both scored same marks");
        }


        Student[] list = {s1,s2,s3,s4};

        System.out.println(Arrays.toString(list)); // Makes use of the overriden toString method in Student class



//        Arrays.sort(list); // Makes use of the overriden compareTo method in Student class


//        Arrays.sort(list, new Comparator<Student>() { // Anonymous class
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.marks-o2.marks;
//            }
//        });


        Arrays.sort(list, (obj1, obj2) -> obj1.marks-obj2.marks); // Doesn't make use of the overriden compareTo method in Student class


        System.out.println(Arrays.toString(list));
    }
}
