package Practice.OOPs.Generics.GenericInterface;

public class Main implements GenericInterface<Integer> {
    public static void main(String[] args) {
        Main obj = new Main();
        obj.display(5);
    }

    @Override
    public void display(Integer num) {
        System.out.println(num);
    }
}
