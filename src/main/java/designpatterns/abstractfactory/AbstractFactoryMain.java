package designpatterns.abstractfactory;

public class AbstractFactoryMain {
    public static void main(String[] args) {
        IFactory factory = new Factory();
        ICar benzCar = factory.createBenzCar();
        benzCar.show();

        ICar audi = factory.createAudiCar();
        audi.show();
    }
}
