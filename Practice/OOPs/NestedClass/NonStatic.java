package Practice.OOPs.NestedClass;

public class NonStatic {

    // class Test  // ERROR
    class Test{
        String name;

        public Test(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        NonStatic obj = new NonStatic();
        Test a = obj.new Test("Kunal"); // Non-Static nested class, used with the help of reference of outer class

        Test b = obj.new Test("Rahul");

        System.out.println(a.name); // Kunal
        System.out.println(b.name); // Rahul
    }
}
