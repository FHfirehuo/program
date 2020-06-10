package designpatterns.chainofresponsibility.cor;

/**
 * $Des$
 *
 * @author liuyi27
 */
public class NoSupport extends Support {

    public NoSupport(String name) {
        super(name);
    }

    protected boolean resolve(Trouble trouble) {
        return false;
    }
}
