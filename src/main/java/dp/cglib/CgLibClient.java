package dp.cglib;

import dp.HelloImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CgLibClient {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloImpl.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                System.out.println("before method run...");
                Object result = methodProxy.invokeSuper(o, args);
                System.out.println("after method run...");
                return result;
            }
        });

        HelloImpl hello = (HelloImpl) enhancer.create();
        hello.sayHello();
        System.out.println("=========");
        System.out.println(hello.toString());
        System.out.println("=========");
        System.out.println(hello.getClass());
        System.out.println("=========");
        System.out.println(hello.hashCode());
    }
}
