package designpatterns.adapter.clazz.example;

/**
 * $Des$
 *
 * @author liuyi27
 */
public class AdapterMain {

    public static void main(String[] args) {
        Target target = new ConcreteTarget();
        target.request();

        Target adapterTarget = new Adapter();
        adapterTarget.request();
    }
}
