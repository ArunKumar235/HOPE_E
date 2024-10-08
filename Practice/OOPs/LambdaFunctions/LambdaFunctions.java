package Practice.OOPs.LambdaFunctions;

import java.util.ArrayList;
import java.util.function.Consumer;

public class LambdaFunctions {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<5; i++){
            list.add(i+1);
        }


        list.forEach((item) -> System.out.print(item + " ")); // this is a lambda function
        System.out.println();


        Consumer<Integer> consumer = (item) -> System.out.print(item + " "); // this is a lambda function assigned to a variable
        // Consumer is a functional interface, which has only one abstract method, accept(T t)
        list.forEach(consumer);


        System.out.println();


        consumer.accept(10);


        Operation add = (a, b) -> a + b; // this is a lambda function assigned to a variable
        Operation sub = (a, b) -> a - b;
        Operation mul = (a, b) -> a * b;
        Operation div = (a, b) -> a / b;

        System.out.println(add.operation(5, 3));

    }
}

interface Operation{
    int operation(int a, int b);
}
