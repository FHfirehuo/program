package designpatterns.facade;

public class Facader {

    private SubMethod1 sm1 = new SubMethod1();
    private SubMethod2 sm2 = new SubMethod2();
    private SubMethod3 sm3 = new SubMethod3();
    public void facMethod1(){
        sm1.method1();
        sm2.method2();
        sm1.method3();
    }
    public void facMethod2(){
        sm2.method2();
        sm3.method3();
        sm1.method1();
    }
}
