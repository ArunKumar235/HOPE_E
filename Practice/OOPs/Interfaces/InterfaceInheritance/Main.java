package Practice.OOPs.Interfaces.InterfaceInheritance;

public class Main implements B{

    //Since B inherits from A, it is mandatory to implement both the functions in A and B
    @Override
    public void greet() {
        System.out.println("greet()");
    }

    @Override
    public void fun() {
        System.out.println("fun()");
    }

    public static void main(String[] args) {
        Main obj = new Main();
        obj.greet();
        obj.fun();
    }
}
