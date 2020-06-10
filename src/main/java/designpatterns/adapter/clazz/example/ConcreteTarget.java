package designpatterns.adapter.clazz.example;

/**
 * 一种错误的实现方式
 *
 * 怎么才可以在目标接口中的 request() 调用 Adaptee 的 adapteeRequest() 方法呢？
 *
 * 如果直接实现 Target 是不行的
 *
 * @author liuyi27
 */
public class ConcreteTarget implements Target {
    public void request() {
        System.out.println("concreteTarget目标方法");
    }
}
