package designpatterns.adapter.clazz.zyr;

public class PrintBanner extends Banner implements Print {

    public PrintBanner(String name) {
        super(name);
    }

    public void printWeak() {
        System.out.println("...开始弱适配...");
        showWithParen();
        System.out.println("...弱适配成功...");
        System.out.println();
    }

    public void printStrong() {
        System.out.println("...开始强适配...");
        showWithAster();
        System.out.println("...强适配成功...");
        System.out.println();
    }
}
