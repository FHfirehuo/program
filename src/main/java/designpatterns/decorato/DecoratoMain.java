package designpatterns.decorato;

public class DecoratoMain {

    public static void main(String[] args) {
        House dongHaoHouse = new DongHaoHouse();
        House decorator = new Decorator(dongHaoHouse);
        decorator.output();
    }
}
