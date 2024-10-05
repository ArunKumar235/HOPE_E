package Practice.OOPs.NestedClass;

public class Static {

    // class Test  // ERROR
     static class Test{
         String name;

        public Test(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
         Static obj = new Static();
        Test a = new Test("Kunal");  // Static nested class used without a reference of outer class

        Test b = new Test("Rahul");

        System.out.println(a.name); // Kunal
        System.out.println(b.name); // Rahul
    }
}