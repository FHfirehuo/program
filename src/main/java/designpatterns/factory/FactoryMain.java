package designpatterns.factory;

public class FactoryMain {
    public static void main(String[] args) {
        IFactory factory = new Factory();
        ICar car = factory.createCar();
        car.show();
    }
}
