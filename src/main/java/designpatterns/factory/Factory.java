package designpatterns.factory;

public class Factory implements IFactory {
    public ICar createCar() {
        Engine engine = new Engine();
        UnderPan underpan = new UnderPan();
        Wheel wheel = new Wheel();
        ICar car = new Car(engine, underpan, wheel);
        return car;
    }
}
