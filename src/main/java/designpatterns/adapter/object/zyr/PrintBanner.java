package designpatterns.adapter.object.zyr;

/**
 * 可以看到Main函数、Banner类都没有改动，将Print接口变成抽象类，那么PrintBanner不能同时继承两个类，
 * 因此将Banner对象组合到适配器之中，因此叫做对象适配器，这样也可以实现预期的结果。
 * 两者的区别也是非常明显的，最好推荐使用前者，或者根据实际情况需要进行甄别。
 *
 * @author liuyi27
 */
public class PrintBanner extends Print {
    Banner banner;
    public PrintBanner(String name) {
        banner=new Banner(name);
    }

    public void printWeak() {
        System.out.println("...开始弱适配...");
        banner.showWithParen();
        System.out.println("...弱适配成功...");
        System.out.println();
    }

    public void printStrong() {
        System.out.println("...开始强适配...");
        banner.showWithAster();
        System.out.println("...强适配成功...");
        System.out.println();
    }
}
