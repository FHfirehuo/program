package designpatterns.decorato;

public class DecoratoMain {

    public static void main(String[] args) {
        House donghaoHouse = new DonghaoHouse();
        House decorator = new Decorator(donghaoHouse);
        decorator.output();
    }
}
