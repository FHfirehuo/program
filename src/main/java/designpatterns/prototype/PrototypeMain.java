package designpatterns.prototype;

/**
 * $Des$
 *
 * @author liuyi27
 */
public class PrototypeMain {
    public static void main(String[] args) {
        Manager m = new  Manager();
        Product p1 = new Underline('@');
        m.register("line", p1);

        Product p2 = new MessageBox('$');
        m.register("msg", p2);
        Product p3 = m.create("line");
        p3.setCh('%');
        Product p4 = m.create("msg");
        p4.setCh('^');
        p1.use("fire");
        p2.use("huo");
        p3.use("love");
        p4.use("1314");

    }
}
