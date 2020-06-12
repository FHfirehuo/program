package designpatterns.adapter.clazz.zyr;

public class PrintBannerMain {

    public static void main(String[] args) {
        Print p = new PrintBanner("Fire");
        p.printStrong();
        p.printWeak();
    }
}
