package designpatterns.bridge.bky;

/**
 * 来源地A1
 */
public class AreaA1 extends AreaA {
    void fromAreaA() {
        System.out.println("我来自A1");
        qiao.targetAreaB();
    }
}
