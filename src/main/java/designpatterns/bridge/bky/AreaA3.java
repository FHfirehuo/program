package designpatterns.bridge.bky;

public class AreaA3 extends AreaA {
    void fromAreaA() {
        System.out.println("我来自A3");
        qiao.targetAreaB();
    }
}
