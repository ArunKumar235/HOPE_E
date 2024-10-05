package Practice.OOPs.Properties.Polymorphism;

public class Shapes {

    void area(){
        System.out.println("Im in shapes");
    }

    public static void main(String[] args) {
        Shapes shape = new Shapes();
        shape.area();
        Circle circle = new Circle();
        circle.area();
        Shapes square = new Square(); // Shapes tells that a method area is accessible by obj, Square tells that use my version of area as it overrides the one in superclass
        // If area method in Shapes is commented, then the object won't be able to call a method in ma,ed are
        // area method in Square overrides method in Shapes
        square.area(); // Upcasting occurs
    }
}