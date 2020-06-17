package designpatterns.template;

/**
 * 因此说模板非常容易理解，使用起来也很简单，但是在工程中我们往往将模板与其他模式结合起来，因此我们要认清模板的本质，将具有相同操作的多种事物抽象出这些相同的操作，然后将这些操作有机的整合起来变成模板类，
 * 另外也要注意在模板方法的定义final表示此方法不能被继承和重写，这无疑是重要的，规定和法则不能被其他人所改变。
 */
public class TemplateMain {

    public static void main(String[] args) {
        AbstractDisplay p = new CharDisplay("zyr");
        p.display();
        System.out.println("----------------");
        p = new StringDisplay("zyr");
        p.display();
    }
}
