package designpatterns.abstractfactory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AudiCar implements ICar {
    private Engine engine;
    private Underpan underpan;
    private Wheel wheel;


    public void show() {
        engine.getStyle();
        underpan.getStyle();
        wheel.getStyle();
        System.out.println("造了一台奥迪汽车");
    }
}
