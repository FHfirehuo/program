package designpatterns.decorato;

//装饰器r
public class Decorator implements House {

    private House house;

    public Decorator(House house) {
        this.house = house;
    }

    public void output() {
        System.out.println("这是针对房子的前段装饰增强");
        house.output();
        System.out.println("这是针对房子的后段装饰增强");
    }
}
