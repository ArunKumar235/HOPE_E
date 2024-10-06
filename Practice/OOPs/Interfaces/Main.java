package Practice.OOPs.Interfaces;

public class Main {
    public static void main(String[] args) {
//        Car car = new Car();
//        car.start();
//        car.acc();
//        car.stop();

//        Engine carEngine = new Car(); // Data type of reference can be Interface name, but access limited to interface properties only, cannot access properties of class
//        carEngine.start(); // I start engine like a normal car
//        Media carMedia = new Car();
//        carMedia.start(); // I start engine like a normal car


        NiceCar car = new NiceCar();
        car.start();
        car.startMusic();
        car.upgradeEngine(new ElectricEngine());
        car.start();
    }
}