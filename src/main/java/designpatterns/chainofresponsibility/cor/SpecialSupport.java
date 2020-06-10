package designpatterns.chainofresponsibility.cor;

/**
 * $Des$
 *
 * @author liuyi27
 */
public class SpecialSupport extends Support{

    public int specialNumber;
    public SpecialSupport(String name,int specialNumber) {
        super(name);
        this.specialNumber= specialNumber;
    }

    protected boolean resolve(Trouble trouble) {
        return trouble.getNumber()==specialNumber ? true : false;
    }
}
