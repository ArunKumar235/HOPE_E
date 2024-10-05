package Practice.OOPs.Properties.Polymorphism.MethodOverload;

class OverloadDemo {
    void test(double a){
        System.out.println("Inside test(double) a: " + a);
    }
}
class Overload {
    public static void main(String[] args) {
        OverloadDemo ob = new OverloadDemo();
        int i = 88;
//         Java will employ its automatic type conversions only if no exact match is found.
        ob.test(i);        // this will invoke test(double) -> automatic type casting occurs
        ob.test(123.2);    // this will invoke test(double)
    }
}