package designpatterns.bridge.bky;

public class AreaA2 extends AreaA {
    void fromAreaA() {

        System.out.println("我来自A2");
        qiao.targetAreaB();
    }
}
