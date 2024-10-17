package Practice.OOPs.ExceptionHandling;

public class Main {
    public static void main(String[] args) {
        int a = 5;
        int b = 0;

//        try{
//            int c = a/b;
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }finally{
//            System.out.println("This will always execute");
//        }


        try{ // Code in try block is executed until an exception occurs
//            throw new Exception("Just a normal exception");
            int c = divide(a,b);
        } catch (ArithmeticException e) { // Code in catch block is executed in case of exception in try block
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println("Normal Exception");
        }finally { // Code in finally block is always executed
            System.out.println("This is always executed");
        }



    }

    public static int divide(int a, int b) throws ArithmeticException{
        // throws - It is used to declare an exception, which means it works as a signal to the programmer that there
        // may occur an exception, so it is better for the programmer to provide the exception handling code so that
        // normal flow can be maintained.
        if(b==0){
            throw new ArithmeticException("Don't divide by ZERO");
            // throw - It is used to explicitly throw an exception from a method or any block of code.
        }
        return a/b;
    }
}
