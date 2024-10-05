package Practice.OOPs.Properties.Polymorphism;


public class Circle extends Shapes {

    @Override // Annotation @Override used to check if a method is overriding another method from its superclass or not
    void area(){
        System.out.println("Area of circle is pie * r * r");
    }
}
