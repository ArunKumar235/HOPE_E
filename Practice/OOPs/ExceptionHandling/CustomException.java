package Practice.OOPs.ExceptionHandling;

public class CustomException {
    public static void main(String[] args) {

        try{
            String name = "Arun";
            if(name.equals("Arun")){
                throw new MyException("Name is Arun");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }

    }
}
