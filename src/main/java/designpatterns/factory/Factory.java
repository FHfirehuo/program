package designpatterns.factory;

public class Factory implements IFactory {
    public ICar createCar() {
        Engine engine = new Engine();
        Underpan underpan = new Underpan();
        Wheel wheel = new Wheel();
        ICar car = new Car(engine, underpan, wheel);
        return car;
    }
}
