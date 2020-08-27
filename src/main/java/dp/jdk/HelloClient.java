package dp.jdk;

import dp.HelloImpl;
import dp.IHello;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

public class HelloClient {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        /*第一种*/
        IHello hello = new HelloImpl();
        hello.sayHello();


        // 生成$Proxy0的class文件
        //System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        /*第二种*/

        HelloInvocationHandler helloInvocationHandler = new HelloInvocationHandler(new HelloImpl());
        IHello hello1 = (IHello) Proxy.newProxyInstance(IHello.class.getClassLoader(), new Class[]{IHello.class}, helloInvocationHandler);
        hello1.sayHello();

        /*第三种*/
        // 1、获取动态代理类
        Class proxy = Proxy.getProxyClass(IHello.class.getClassLoader(), IHello.class);
        // 2、获得代理类的构造函数，并传入参数类型InvocationHandler.class
        Constructor constructor = proxy.getConstructor(InvocationHandler.class);
        // 3、通过构造函数来创建动态代理对象，将自定义的InvocationHandler实例传入
        IHello hello2 = (IHello) constructor.newInstance(new HelloInvocationHandler(new HelloImpl()));
        hello2.sayHello();


    }
}
