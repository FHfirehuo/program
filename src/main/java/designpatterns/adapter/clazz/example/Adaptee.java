package designpatterns.adapter.clazz.example;

/**
 * 一个将被适配的类
 */
public class Adaptee {

    public void adapteeRequest() {
        System.out.println("被适配者的方法");
    }
}
