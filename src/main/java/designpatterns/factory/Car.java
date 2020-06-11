package designpatterns.factory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Car implements ICar {


    private Engine engine;
    private UnderPan underpan;
    private Wheel wheel;


    public void show() {
        engine.getStyle();
        underpan.getStyle();
        wheel.getStyle();
        System.out.println("造了一个汽车");
    }
}
