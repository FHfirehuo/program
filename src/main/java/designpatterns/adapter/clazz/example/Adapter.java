package designpatterns.adapter.clazz.example;

/**
 * 一个正确的方式
 *
 * 如果通过一个适配器类，实现 Target 接口，同时继承了 Adaptee 类，然后在实现的 request() 方法中调用父类的 adapteeRequest() 即可实现
 *
 */
public class Adapter extends Adaptee implements Target {
    public void request() {
        //...一些操作...
        super.adapteeRequest();
        //...一些操作...
    }
}
