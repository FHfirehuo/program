package designpatterns.adapter.clazz.zyr;

/**
 * $Des$
 *
 * @author liuyi27
 */
public class PrintBannerMain {

    public static void main(String[] args) {
        Print p=new PrintBanner("朱彦荣");
        p.printStrong();
        p.printWeak();
    }
}
