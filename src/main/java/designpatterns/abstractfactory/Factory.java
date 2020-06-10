package designpatterns.abstractfactory;

public class Factory implements IFactory {
    public ICar createBenzCar() {
        Engine engine = new Engine();
        Underpan underpan = new Underpan();
        Wheel wheel = new Wheel();
        ICar car = new BenzCar(engine, underpan, wheel);
        return car;
    }

    public ICar createAudiCar() {
        Engine engine = new Engine();
        Underpan underpan = new Underpan();
        Wheel wheel = new Wheel();
        ICar car = new AudiCar(engine, underpan, wheel);
        return car;
    }
}
