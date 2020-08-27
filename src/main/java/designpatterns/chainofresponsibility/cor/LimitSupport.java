package designpatterns.chainofresponsibility.cor;

public class LimitSupport extends Support {

    private int limit;

    public LimitSupport(String name, int limit) {
        super(name);
        this.limit = limit;
    }

    protected boolean resolve(Trouble trouble) {
        return trouble.getNumber() <= limit ? true : false;
    }
}
