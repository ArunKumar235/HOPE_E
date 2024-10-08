package Practice.OOPs.Generics.Comparing;

public class Student implements Comparable<Student> {
    int roll;
    int marks;

    public Student(int roll, int marks) {
        this.roll = roll;
        this.marks = marks;
    }

    @Override
    public int compareTo(Student o) {

        // diff == 0 both are equal
        // diff > 0 this.marks > o.marks
        // diff < 0 this.marks < o.marks

        int diff = (int)(this.marks- o.marks);
        return diff;
    }

    @Override
    public String toString(){
        return roll + " scored " + marks;
    }
}
