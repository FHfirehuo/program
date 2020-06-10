package designpatterns.template;

/**
 * $Des$
 *
 * @author liuyi27
 */
public abstract class AbstractDisplay {

    public abstract void open();
    public abstract void print();
    public abstract void close();
    public  final void display(){
        open();
        print();
        close();
    }
}
